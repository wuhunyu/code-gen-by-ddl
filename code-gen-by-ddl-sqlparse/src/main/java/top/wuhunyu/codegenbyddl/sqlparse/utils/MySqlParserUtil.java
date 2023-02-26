package top.wuhunyu.codegenbyddl.sqlparse.utils;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlCreateTableParser;
import lombok.extern.slf4j.Slf4j;
import top.wuhunyu.codegenbyddl.core.anna.NotNull;
import top.wuhunyu.codegenbyddl.core.enums.YesOrNoEnum;
import top.wuhunyu.codegenbyddl.sqlparse.dto.SqlDataInfoDto;
import top.wuhunyu.codegenbyddl.sqlparse.dto.SqlFiledInfoDto;
import top.wuhunyu.codegenbyddl.sqlparse.dto.SqlTableInfoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * MySql ddl 语句解析器
 *
 * @author wuhunyu
 * @date 2023/02/10 16:22
 **/

@Slf4j(topic = "MySql ddl 语句解析器")
public final class MySqlParserUtil {

    private MySqlParserUtil() {
    }

    /**
     * 解析 sql 脚本，并返回解析数据结果
     *
     * @param sqlStr sql ddl 脚本
     * @return 解析结果
     */
    public static SqlDataInfoDto parseDdlStr(@NotNull String sqlStr) {
        Objects.requireNonNull(sqlStr, "sql 脚本不能为空");

        // 调用 druid 内置 sql 解析器 进行解析
        MySqlCreateTableParser mySqlCreateTableParser = new MySqlCreateTableParser(sqlStr);

        SQLCreateTableStatement sqlCreateTableStatement = mySqlCreateTableParser.parseCreateTable();
        // 获取解析器失败，直接返回
        if (sqlCreateTableStatement == null) {
            return null;
        }
        // 从解析器中获取 解析结果
        // 字段信息
        List<SqlFiledInfoDto> sqlFiledInfos = MySqlParserUtil.collectFiledInfo(sqlCreateTableStatement);
        // 计算主键数量
        int primaryKeyCount = (int) sqlFiledInfos.stream()
                .map(SqlFiledInfoDto::getPrimaryKey)
                .filter(primaryKey -> primaryKey == YesOrNoEnum.YES.getStatus())
                .count();
        // 表信息
        SqlTableInfoDto sqlTableInfo = MySqlParserUtil.collectTableInfo(sqlCreateTableStatement, primaryKeyCount);
        // 组装 表数据
        return new SqlDataInfoDto(
                sqlTableInfo,
                sqlFiledInfos
        );
    }

    /**
     * 收集 表字段信息
     *
     * @param sqlCreateTableStatement sql 建表对象
     * @return 字段信息
     */
    private static List<SqlFiledInfoDto> collectFiledInfo(SQLCreateTableStatement sqlCreateTableStatement) {
        // 结果容器
        List<SqlFiledInfoDto> sqlFiledInfos = new ArrayList<>();
        sqlCreateTableStatement.forEachColumn(columnConsumer -> {
            // 字段名称
            String columnName = columnConsumer.getColumnName();
            // 字段类型
            String dataType = columnConsumer.getDataType().getName();
            // 字段注释
            SQLExpr fieldComment = columnConsumer.getComment();
            String comment = fieldComment == null ? "" : fieldComment.toString();
            // 是否为主键
            boolean primaryKey = columnConsumer.isPrimaryKey();
            sqlFiledInfos.add(new SqlFiledInfoDto(
                    StrUtil.cleanName(columnName),
                    // 字段类型 取小写
                    dataType.toLowerCase(),
                    // 注释需要经过简单的 清理
                    StrUtil.cleanSqlComment(comment),
                    primaryKey ? YesOrNoEnum.YES.getStatus() : YesOrNoEnum.NO.getStatus()
            ));
        });
        return sqlFiledInfos;
    }

    /**
     * 收集 表信息
     *
     * @param sqlCreateTableStatement sql 建表对象
     * @param primaryKeyCount         主键数量
     * @return 表信息
     */
    private static SqlTableInfoDto collectTableInfo(SQLCreateTableStatement sqlCreateTableStatement,
                                                    int primaryKeyCount) {
        // 表名称
        String tableName = sqlCreateTableStatement.getTableName();
        // 表注释
        SQLExpr tableComment = sqlCreateTableStatement.getComment();
        String comment = tableComment == null ? "" : tableComment.toString();
        return new SqlTableInfoDto(
                StrUtil.cleanName(tableName),
                // 简单清理 注释
                StrUtil.cleanSqlComment(comment),
                primaryKeyCount
        );
    }

}
