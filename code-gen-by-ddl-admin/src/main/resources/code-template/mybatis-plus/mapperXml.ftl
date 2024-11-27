<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${entityTemplate.packageName}.mapper.${entityTemplate.className}${entityTemplate.suffix}Mapper">

    <sql id="sqlFields">
<#list entityFiledTemplates as entityFiledTemplate>
    <#if !entityFiledTemplate_has_next>
        ${entityFiledTemplate.sourceFiledName}
    <#else>
        ${entityFiledTemplate.sourceFiledName},
    </#if>
</#list>
    </sql>

    <resultMap id="baseMap" type="${entityTemplate.packageName}.entity.${entityTemplate.className}${entityTemplate.suffix}">
<#list entityFiledTemplates as entityFiledTemplate>
    <#if entityFiledTemplate.primaryKey>
        <id property="${entityFiledTemplate.filedName}" column="${entityFiledTemplate.sourceFiledName}"/>
    <#else>
        <result property="${entityFiledTemplate.filedName}" column="${entityFiledTemplate.sourceFiledName}"/>
    </#if>
</#list>
    </resultMap>

</mapper>