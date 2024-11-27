package ${entityTemplate.packageName}.${entityTemplate.moduleName}.service.impl;

/**
 * ${entityTemplate.comment!''} service 实现
 *
 * @author ${entityTemplate.authorName!''}
 * @date ${entityTemplate.createDatetime}
 **/

<#if entityTemplate.suffix??>
@DataSourceScope(DataScope.${entityTemplate.suffix})
</#if>
@Service("${entityTemplate.camelCaseName}${entityTemplate.suffix}Service")
@Slf4j
@RequiredArgsConstructor
public class ${entityTemplate.className}ServiceImpl extends ServiceImpl<${entityTemplate.className}${entityTemplate.suffix}Mapper, ${entityTemplate.className}${entityTemplate.suffix}> {



}