package top.wuhunyu.codegenbyddl.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.wuhunyu.codegenbyddl.admin.constants.Constant;
import top.wuhunyu.codegenbyddl.admin.exception.CustomerException;
import top.wuhunyu.codegenbyddl.admin.vo.ResponseVo;

import java.util.List;

/**
 * 全局异常处理
 *
 * @author wuhunyu
 * @date 2023/02/14 11:41
 **/

@RestControllerAdvice
@Slf4j(topic = "全局异常处理")
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseVo<String> exceptionHandler(Exception e) {
        log.info("异常类型 Exception，异常堆栈信息: {}", e.getLocalizedMessage(), e);
        return ResponseVo.fail(Constant.DEFAULT_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseVo<String> customerExceptionHandler(CustomerException e) {
        log.info("异常类型 CustomerException，异常堆栈信息: {}", e.getLocalizedMessage(), e);
        return ResponseVo.fail(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public ResponseVo<String> bindException(BindException e) {
        log.info("异常类型 BindException，异常堆栈信息: {}", e.getLocalizedMessage(), e);
        List<ObjectError> allErrors = e.getBindingResult()
                .getAllErrors();
        return ResponseVo.fail(allErrors.get(0).getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseVo<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info("异常类型 MethodArgumentNotValidException，异常堆栈信息: {}", e.getLocalizedMessage(), e);
        List<ObjectError> allErrors = e.getBindingResult()
                .getAllErrors();
        return ResponseVo.fail(allErrors.get(0).getDefaultMessage());
    }

}
