package top.wuhunyu.codegenbyddl.sqlparse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.wuhunyu.codegenbyddl.core.anna.NotNull;
import top.wuhunyu.codegenbyddl.core.anna.Nullable;

import java.io.Serializable;

/**
 * sql 解析的表信息
 *
 * @author wuhunyu
 * @date 2023/02/10 16:24
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SqlTableInfoDto implements Serializable {

    private static final long serialVersionUID = 602484746537649277L;

    /**
     * 表名
     */
    @NotNull
    private String tableName;

    /**
     * 表注释
     */
    @Nullable
    private String tableComment;

    /**
     * 表的主键数量
     */
    @NotNull
    private Integer primaryKeyCount;

}
