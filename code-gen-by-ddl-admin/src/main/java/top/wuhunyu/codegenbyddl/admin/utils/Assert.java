package top.wuhunyu.codegenbyddl.admin.utils;

import top.wuhunyu.codegenbyddl.admin.exception.CustomerException;

/**
 * 断言工具类
 *
 * @author wuhunyu
 * @date 2023/02/14 11:37
 **/

public final class Assert {

    private Assert() {
    }

    /**
     * 断言
     *
     * @param expression       表达式(true: 无任何操作; false: 抛出自定义异常)
     * @param exceptionMessage 异常提示信息
     */
    public static void isTrue(boolean expression, String exceptionMessage) {
        if (!expression) {
            Assert.isTrue(exceptionMessage);
        }
    }

    /**
     * 断言
     *
     * @param exceptionMessage 异常提示信息
     */
    public static void isTrue(String exceptionMessage) {
        throw new CustomerException(exceptionMessage);
    }

}
