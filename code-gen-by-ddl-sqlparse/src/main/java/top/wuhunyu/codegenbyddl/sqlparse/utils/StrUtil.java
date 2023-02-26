package top.wuhunyu.codegenbyddl.sqlparse.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串操作
 *
 * @author wuhunyu
 * @date 2023/02/10 17:06
 **/

public final class StrUtil {

    /**
     * 空字符串
     */
    private static final String BLANK = "";

    /**
     * 单引号
     */
    private static final char SINGLE_QUOTATION_MARK = '\'';

    /**
     * 双引号
     */
    private static final char DOUBLE_QUOTATION_MARK = '\"';

    /**
     * 空格
     */
    private static final char BLANK_CHAR = ' ';

    /**
     * 着重符
     */
    private static final char STAR = '`';

    private StrUtil() {
    }

    /**
     * 清理 sql 注释中的 " 或 ' 以及 两侧的 空格
     *
     * @param comment sql 注释
     * @return 清理之后的 sql 注释
     */
    public static String cleanSqlComment(String comment) {
        if (StringUtils.isBlank(comment) || comment.length() < 2) {
            return StringUtils.isBlank(comment) ? BLANK : comment;
        }
        // 去除两侧的 " 或 ' 以及 两侧的 空格
        int length = comment.length();
        int left = 0;
        int right = length - 1;
        if ((comment.charAt(left) == SINGLE_QUOTATION_MARK && comment.charAt(right) == SINGLE_QUOTATION_MARK ||
                comment.charAt(left) == DOUBLE_QUOTATION_MARK && comment.charAt(right) == DOUBLE_QUOTATION_MARK)) {
            left++;
            right--;
        }
        while (left < right && comment.charAt(left) == BLANK_CHAR) {
            left++;
        }
        while (left < right && comment.charAt(right) == BLANK_CHAR) {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            sb.append(comment.charAt(left++));
        }
        return sb.toString();
    }

    /**
     * 清洗 表名 字段名 两侧的 着重符号
     *
     * @param name 表名 | 字段名
     * @return 清洗之后的 表名 | 字段名
     */
    public static String cleanName(String name) {
        if (StringUtils.isBlank(name) || name.length() < 2) {
            return StringUtils.isBlank(name) ? BLANK : name;
        }
        // 去除 表名 字段名 两侧的 着重符号
        int left = 0;
        int right = name.length() - 1;
        while (left < right && name.charAt(left) == STAR) {
            left++;
        }
        while (left < right && name.charAt(right) == STAR) {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            sb.append(name.charAt(left++));
        }
        return sb.toString();
    }

}
