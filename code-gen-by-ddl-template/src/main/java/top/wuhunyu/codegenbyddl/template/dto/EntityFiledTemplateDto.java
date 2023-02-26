package top.wuhunyu.codegenbyddl.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.wuhunyu.codegenbyddl.core.anna.NotNull;
import top.wuhunyu.codegenbyddl.core.anna.Nullable;

import java.io.Serializable;

/**
 * 实体字段Dto
 *
 * @author wuhunyu
 * @date 2023/02/13 10:40
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityFiledTemplateDto implements Serializable {

    private static final long serialVersionUID = 6245711515241541328L;

    /**
     * 字段名称
     */
    @NotNull
    private String filedName;

    /**
     * 原始字段名称(即表字段名称)
     */
    @NotNull
    private String sourceFiledName;

    /**
     * 字段类型
     */
    @NotNull
    private String filedType;

    /**
     * 是否为主键
     *
     * @see top.wuhunyu.codegenbyddl.core.enums.YesOrNoEnum
     */
    @NotNull
    private Boolean primaryKey;

    /**
     * 是否为逻辑删除字段
     *
     * @see top.wuhunyu.codegenbyddl.core.enums.YesOrNoEnum
     */
    @NotNull
    private Boolean logicDelete;

    /**
     * 是否为乐观锁字段
     *
     * @see top.wuhunyu.codegenbyddl.core.enums.YesOrNoEnum
     */
    @NotNull
    private Boolean optimisticVersion;

    /**
     * 日期格式化
     * 仅当 filedType 为日期类型时有效
     */
    @Nullable
    private String dateFormat;

    /**
     * 字段注释
     */
    @Nullable
    private String comment;

}
