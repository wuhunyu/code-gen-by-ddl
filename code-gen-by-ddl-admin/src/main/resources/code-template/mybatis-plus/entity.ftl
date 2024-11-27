package ${entityTemplate.packageName}.${entityTemplate.moduleName}.entity;

/**
 * ${entityTemplate.comment!''}
 *
 * @author ${entityTemplate.authorName!''}
 * @date ${entityTemplate.createDatetime}
 **/

@TableName("${entityTemplate.sourceTableName}")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ${entityTemplate.className}${entityTemplate.suffix} implements Serializable {

    private static final long serialVersionUID = ${entityTemplate.serialVersion}L;

<#list entityFiledTemplates as entityFiledTemplate>
    private ${entityFiledTemplate.filedType} ${entityFiledTemplate.filedName};

</#list>
}