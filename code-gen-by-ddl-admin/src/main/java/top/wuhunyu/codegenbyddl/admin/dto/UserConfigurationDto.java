package top.wuhunyu.codegenbyddl.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import top.wuhunyu.codegenbyddl.admin.properties.ConfigurationProperty;

import java.io.Serializable;

/**
 * 用户配置
 *
 * @author wuhunyu
 * @date 2023/02/14 08:18
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserConfigurationDto implements Serializable {

    private static final long serialVersionUID = -343791881505635842L;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 作者名称
     */
    private String authorName;

    /**
     * 表前缀
     */
    private String tablePrefix;

    /**
     * 后缀
     */
    private String suffix;

    /**
     * 创建日期时间(yyyy-MM-dd HH:mm:dd)
     */
    private String createDatetime;

    /**
     * 补全 用户配置 属性
     *
     * @param packageName     包名
     * @param moduleName      模块名
     * @param authorName      作者
     * @param tablePrefix     表前缀
     * @param createDatetime  创建日期
     * @param defaultProperty 默认配置属性
     * @return 用户配置 属性
     */
    public static UserConfigurationDto of(String packageName, String moduleName, String authorName, String tablePrefix,
                                          String suffix, String createDatetime, ConfigurationProperty defaultProperty) {
        UserConfigurationDto userConfigurationDto = new UserConfigurationDto();
        // 包名
        userConfigurationDto.setPackageName(StringUtils.isBlank(packageName) ?
                defaultProperty.getPackageName() : packageName);
        // 模块名
        userConfigurationDto.setModuleName(StringUtils.isBlank(moduleName) ?
                defaultProperty.getModuleName() : moduleName);
        // 作者
        userConfigurationDto.setAuthorName(StringUtils.isBlank(authorName) ?
                defaultProperty.getAuthorName() : authorName);
        // 表前缀
        userConfigurationDto.setTablePrefix(StringUtils.isBlank(tablePrefix) ?
                "" : tablePrefix);
        // 后缀
        userConfigurationDto.setSuffix(StringUtils.isBlank(suffix) ?
                "" : suffix);
        // 创建日期
        userConfigurationDto.setCreateDatetime(StringUtils.isBlank(createDatetime) ?
                "" : createDatetime);
        return userConfigurationDto;
    }

}
