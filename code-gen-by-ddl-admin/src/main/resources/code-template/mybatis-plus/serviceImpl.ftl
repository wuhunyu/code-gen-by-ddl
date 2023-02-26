package ${entityTemplate.packageName}.${entityTemplate.moduleName}.service.impl;

/**
 * ${entityTemplate.comment!''} service 实现
 *
 * @author ${entityTemplate.authorName!''}
 * @date ${entityTemplate.createDatetime}
 **/

@Service("${entityTemplate.camelCaseName}Service")
@Slf4j
@RequiredArgsConstructor
public class ${entityTemplate.className}ServiceImpl extends ServiceImpl<${entityTemplate.className}Mapper, ${entityTemplate.className}> implements ${entityTemplate.className}Service {



}