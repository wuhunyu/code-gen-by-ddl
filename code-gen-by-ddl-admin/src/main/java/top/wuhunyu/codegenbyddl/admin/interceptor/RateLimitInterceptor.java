package top.wuhunyu.codegenbyddl.admin.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import top.wuhunyu.codegenbyddl.admin.vo.ResponseVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.Semaphore;

/**
 * 流量限制拦截器
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023/2/14 21:05
 */

@Slf4j
public class RateLimitInterceptor implements HandlerInterceptor {

    private final Semaphore semaphore;

    public RateLimitInterceptor(int limit) {
        semaphore = new Semaphore(limit);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 通过
        if (semaphore.tryAcquire()) {
            return true;
        }
        // Content-Type
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        ResponseVo<String> fail = ResponseVo.limit();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            writer.append(objectMapper.writeValueAsString(fail));
        } finally {
            writer.flush();
        }
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        semaphore.release();
    }
}
