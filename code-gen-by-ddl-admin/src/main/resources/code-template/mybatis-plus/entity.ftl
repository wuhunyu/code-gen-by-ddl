package ${entityTemplate.packageName}.${entityTemplate.moduleName}.entity;

/**
 * ${entityTemplate.comment!''}
 *
 * @author ${entityTemplate.authorName!''}
 * @date ${entityTemplate.createDatetime}
 **/

<#if entityTemplate.suffix?has_content && entityTemplate.suffix == "V7">
@TableName(CommonConstants.TEMP_TABLE_PREFIX + "${entityTemplate.sourceTableName}")
<#else>
@TableName("${entityTemplate.sourceTableName}")
</#if>
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ${entityTemplate.className}${entityTemplate.suffix} implements Serializable {

    private static final long serialVersionUID = ${entityTemplate.serialVersion}L;

<#list entityFiledTemplates as entityFiledTemplate>
    private ${entityFiledTemplate.filedType} ${entityFiledTemplate.filedName};

</#list>
}