package top.wuhunyu.codegenbyddl.core.anna;

import java.lang.annotation.*;

/**
 * 可为空标记
 * 标识该 字段 可能为空(可能为 null)，注解只有标识提醒作用，实际不做任何处理
 *
 * @author wuhunyu
 * @date 2023/02/10 16:41
 **/

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Nullable {
}
