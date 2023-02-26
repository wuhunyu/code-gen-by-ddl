package ${entityTemplate.packageName}.${entityTemplate.moduleName}.entity;

/**
 * ${entityTemplate.comment!''}
 *
 * @author ${entityTemplate.authorName!''}
 * @date ${entityTemplate.createDatetime}
 **/

@ApiModel(description = "${entityTemplate.comment!''}")
@TableName("${entityTemplate.sourceTableName}")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ${entityTemplate.className} implements Serializable {

    private static final long serialVersionUID = ${entityTemplate.serialVersion}L;

<#list entityFiledTemplates as entityFiledTemplate>
<#if entityFiledTemplate.logicDelete>
    /**
     * ${entityFiledTemplate.comment}
     */
    @TableLogic
    @JSONField(serialize = false)
<#elseif entityFiledTemplate.optimisticVersion>
    /**
     * ${entityFiledTemplate.comment}
     */
    @JSONField(serialize = false)
    @Version
<#else>
<#if entityFiledTemplate.comment??>
    /**
     * ${entityFiledTemplate.comment}
     */
    @ApiModelProperty(value = "${entityFiledTemplate.comment}")
</#if>
<#if entityTemplate.singlePrimaryKey && entityFiledTemplate.primaryKey>
    @TableId(type = IdType.ASSIGN_ID)
</#if>
<#if entityFiledTemplate.filedType == "Long">
    @JsonSerialize(using = ToStringSerializer.class)
</#if>
<#if entityFiledTemplate.dateFormat?? && entityFiledTemplate.dateFormat?length gt 0>
    @JsonFormat(pattern = "${entityFiledTemplate.dateFormat}")
</#if>
    private ${entityFiledTemplate.filedType} ${entityFiledTemplate.filedName};

</#if>
</#list>
}