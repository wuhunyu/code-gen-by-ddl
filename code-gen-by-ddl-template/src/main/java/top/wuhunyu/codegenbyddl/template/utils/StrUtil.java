package top.wuhunyu.codegenbyddl.template.utils;

import cn.hutool.core.util.IdUtil;

import java.util.Objects;

/**
 * 字符串操作工具类
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023/2/13 21:25
 */

public final class StrUtil {

    /**
     * 下划线
     */
    private static final char UNDER_LINE = '_';

    /**
     * 中划线
     */
    private static final char MIDDLE_LINE = '-';

    private StrUtil() {
    }

    /**
     * 下划线命名 -> 驼峰命名(首字母大写)
     *
     * @param underlineCase 下划线命名
     * @return 驼峰命名(首字母大写)
     */
    public static String underlineCase2BigCamelCase(String underlineCase) {
        return StrUtil.underlineCase2CamelCase(underlineCase, true);
    }

    /**
     * 下划线命名 -> 驼峰命名(首字母小写)
     *
     * @param underlineCase 下划线命名
     * @return 驼峰命名(首字母小写)
     */
    public static String underlineCase2CamelCase(String underlineCase) {
        return StrUtil.underlineCase2CamelCase(underlineCase, false);
    }

    /**
     * 下划线命名 -> 驼峰命名
     *
     * @param underlineCase 下划线命名
     * @param firstLetter   首字母是否大写(true: 首字母大写; false: 首字母小写)
     * @return 驼峰命名
     */
    private static String underlineCase2CamelCase(String underlineCase, boolean firstLetter) {
        Objects.requireNonNull(underlineCase, "下划线命名字符串不能为空");

        StringBuilder sb = new StringBuilder();
        int length = underlineCase.length();
        for (int i = 0; i < length; i++) {
            if (UNDER_LINE == underlineCase.charAt(i)) {
                // 下划线
                firstLetter = true;
                continue;
            }
            if (firstLetter) {
                firstLetter = false;
                sb.append(Character.toUpperCase(underlineCase.charAt(i)));
                continue;
            }
            sb.append(underlineCase.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 下划线命名 -> 蛇形命名
     *
     * @param underlineCase 下划线命名
     * @return 蛇形命名
     */
    public static String underlineCase2SnakeCase(String underlineCase) {
        Objects.requireNonNull(underlineCase, "下划线命名字符串不能为空");

        return underlineCase.replaceAll(String.valueOf(UNDER_LINE), String.valueOf(MIDDLE_LINE));
    }

    /**
     * 雪花算法生成一个唯一的 id
     *
     * @return 唯一 id
     */
    public static String generateUniqueId() {
        return IdUtil.getSnowflakeNextIdStr();
    }

    /**
     * 多个路径合并
     *
     * @param path 文件路径
     * @return 合并路径
     */
    public static String pathMerge(String... path) {
        // 返回空
        if (path == null || path.length == 0) {
            return "";
        }
        return cn.hutool.core.util.StrUtil.join("/", path);
    }

}
