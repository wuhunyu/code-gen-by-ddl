package ${entityTemplate.packageName}.${entityTemplate.moduleName}.service;

/**
* ${entityTemplate.comment!''} service
*
* @author ${entityTemplate.authorName!''}
* @date ${entityTemplate.createDatetime}
**/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ${entityTemplate.className}Converter extends NormalConvert {

    ${entityTemplate.className}V7 to${entityTemplate.className}V7(${entityTemplate.className}V6 ${entityTemplate.camelCaseName}V6);

    List<${entityTemplate.className}V7> to${entityTemplate.className}V7(List<${entityTemplate.className}V6> ${entityTemplate.camelCaseName}sV6);

}