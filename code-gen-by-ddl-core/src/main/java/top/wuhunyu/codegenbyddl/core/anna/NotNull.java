package top.wuhunyu.codegenbyddl.core.anna;

import java.lang.annotation.*;

/**
 * 非空标记
 * 标识该 字段 非空(不为 null)，注解只有标识提醒作用，实际不做任何处理
 *
 * @author wuhunyu
 * @date 2023/02/10 16:39
 **/

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface NotNull {
}
