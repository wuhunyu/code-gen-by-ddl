package top.wuhunyu.codegenbyddl.sqlparse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.wuhunyu.codegenbyddl.core.anna.NotNull;
import top.wuhunyu.codegenbyddl.core.anna.Nullable;

import java.io.Serializable;

/**
 * sql 解析的字段信息
 *
 * @author wuhunyu
 * @date 2023/02/10 16:27
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SqlFiledInfoDto implements Serializable {

    private static final long serialVersionUID = -4265731481111665272L;

    /**
     * 字段名称
     */
    @NotNull
    private String filedName;

    /**
     * 字段类型
     */
    @NotNull
    private String filedType;

    /**
     * 字段注释
     */
    @Nullable
    private String filedComment;

    /**
     * 是否为主键
     * 值与 YesOrNoEnum 枚举对应(yes: 主键, no: 非主键)
     *
     * @see top.wuhunyu.codegenbyddl.core.enums.YesOrNoEnum
     */
    @NotNull
    private Integer primaryKey;

}
