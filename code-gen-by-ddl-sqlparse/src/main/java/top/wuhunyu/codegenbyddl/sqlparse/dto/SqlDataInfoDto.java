package top.wuhunyu.codegenbyddl.sqlparse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.wuhunyu.codegenbyddl.core.anna.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * sql ddl 语句解析结果
 *
 * @author wuhunyu
 * @date 2023/02/10 16:33
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SqlDataInfoDto implements Serializable {

    private static final long serialVersionUID = -761370043787516563L;

    /**
     * 表信息
     */
    @NotNull
    private SqlTableInfoDto sqlTableInfo;

    /**
     * 字段信息
     */
    @NotNull
    private List<SqlFiledInfoDto> sqlFiledInfos;

}
