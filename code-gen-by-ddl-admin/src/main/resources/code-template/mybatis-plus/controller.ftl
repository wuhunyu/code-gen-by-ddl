package ${entityTemplate.packageName}.${entityTemplate.moduleName}.controller;

/**
* ${entityTemplate.comment!''} controller
*
* @author ${entityTemplate.authorName!''}
* @date ${entityTemplate.createDatetime}
**/

@Api(tags = "${entityTemplate.comment!''}")
@RestController
@RequestMapping("/${entityTemplate.snakeCaseName}")
@RequiredArgsConstructor
public class ${entityTemplate.className}Controller {

    private final ${entityTemplate.className}Service ${entityTemplate.camelCaseName}Service;



}