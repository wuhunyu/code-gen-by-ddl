package ${entityTemplate.packageName}.${entityTemplate.moduleName}.mapper;

/**
 * ${entityTemplate.comment!''} mapper
 *
 * @author ${entityTemplate.authorName!''}
 * @date ${entityTemplate.createDatetime}
 **/

<#if entityTemplate.suffix??>
@DataSourceScope(DataScope.${entityTemplate.suffix})
</#if>
public interface ${entityTemplate.className}${entityTemplate.suffix}Mapper extends BaseMapper<${entityTemplate.className}${entityTemplate.suffix}> {



}