package top.wuhunyu.codegenbyddl.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import top.wuhunyu.codegenbyddl.admin.constants.Constant;

import java.io.Serializable;

/**
 * 响应Vo
 *
 * @author wuhunyu
 * @date 2023/02/14 09:42
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVo<T> implements Serializable {

    private static final long serialVersionUID = -7005253641993010131L;

    private Integer code;

    private String message;

    private T data;

    public static <T> ResponseVo<T> success() {
        return ResponseVo.success(null);
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<>(
                HttpStatus.OK.value(),
                Constant.SUCCESS_MESSAGE,
                data
        );
    }

    public static <T> ResponseVo<T> fail() {
        return new ResponseVo<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                Constant.FAIL_MESSAGE,
                null
        );
    }

    public static <T> ResponseVo<T> fail(String message) {
        return new ResponseVo<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                message,
                null
        );
    }

    public static <T> ResponseVo<T> limit() {
        return new ResponseVo<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                Constant.LIMIT_MESSAGE,
                null
        );
    }

}
