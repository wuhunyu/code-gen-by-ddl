package top.wuhunyu.codegenbyddl.admin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 自定义业务异常
 *
 * @author wuhunyu
 * @date 2023/02/14 11:35
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerException extends RuntimeException {

    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常提示信息
     */
    private String message;

    public CustomerException(String message) {
        super(message);
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = message;
    }

}
