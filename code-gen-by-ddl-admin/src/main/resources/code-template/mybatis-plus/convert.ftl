package ${entityTemplate.packageName}.${entityTemplate.moduleName}.service;

/**
* ${entityTemplate.comment!''} service
*
* @author ${entityTemplate.authorName!''}
* @date ${entityTemplate.createDatetime}
**/

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ${entityTemplate.className}Converter extends NormalConvert {

    ${entityTemplate.className}${entityTemplate.suffix} to${entityTemplate.className}${entityTemplate.suffix}(${entityTemplate.className}${entityTemplate.suffix} ${entityTemplate.camelCaseName}${entityTemplate.suffix});

    List<${entityTemplate.className}${entityTemplate.suffix}> to${entityTemplate.className}${entityTemplate.suffix}(List<${entityTemplate.className}${entityTemplate.suffix}> ${entityTemplate.camelCaseName}s${entityTemplate.suffix});

}