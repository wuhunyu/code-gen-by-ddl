package top.wuhunyu.codegenbyddl.admin.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间处理工具类
 *
 * @author wuhunyu
 * @date 2023/02/14 12:05
 **/

public final class DateUtil {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private DateUtil() {
    }

    /**
     * 日期时间字符串格式转化
     *
     * @param dateStr   日期时间字符串
     * @param toPattern 目标格式
     * @return 目标格式的日期时间字符串
     */
    public static String datetimeChange(String dateStr, String toPattern) {
        // 空
        if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(toPattern)) {
            return dateStr;
        }
        // 开始解析
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DATE_TIME_FORMATTER);
        return localDateTime.format(DateTimeFormatter.ofPattern(toPattern));
    }

    /**
     * 当前日期时间转化
     *
     * @param toPattern 目标格式
     * @return 目标格式的日期时间字符串
     */
    public static String formatDatetime(String toPattern) {
        // 空
        if (StringUtils.isBlank(toPattern)) {
            return "";
        }
        return LocalDateTime.now()
                .atZone(ZoneId.of("GMT+8"))
                .format(DateTimeFormatter.ofPattern(toPattern));
    }

}
