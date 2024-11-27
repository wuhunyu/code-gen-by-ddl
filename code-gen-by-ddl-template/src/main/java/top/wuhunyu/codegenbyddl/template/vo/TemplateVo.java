package top.wuhunyu.codegenbyddl.template.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

import static top.wuhunyu.codegenbyddl.template.constants.TemplateConstant.*;

/**
 * 模板Vo
 *
 * @author wuhunyu
 * @date 2023/02/13 11:43
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateVo implements Serializable {

    private static final long serialVersionUID = 1282683977917168593L;

    /**
     * 实体类 解析结果
     */
    private String entity;

    /**
     * mapper 解析结果
     */
    private String mapper;

    /**
     * mapper xml 解析结果
     */
    private String mapperXml;

    /**
     * service 接口 解析结果
     */
    private String service;

    /**
     * service 接口实现 解析结果
     */
    private String serviceImpl;

    /**
     * controller 解析结果
     */
    private String controller;

    /**
     * convert 转换器 解析结果
     */
    private String convert;

    /**
     * 根据 模板名称 给 字段 赋值
     *
     * @param templateName 模板名称
     * @param value        解析值
     */
    public void setFiled(String templateName, String value) {
        if (StringUtils.isBlank(templateName)) {
            return;
        }
        // 获取字段映射关系
        switch (templateName) {
            case ENTITY_FILE:
                this.entity = value;
                break;
            case MAPPER_INTERFACE_FILE:
                this.mapper = value;
                break;
            case MAPPER_XML_FILE:
                this.mapperXml = value;
                break;
            case SERVICE_FILE:
                this.service = value;
                break;
            case SERVICE_IMPL_FILE:
                this.serviceImpl = value;
                break;
            case CONTROLLER_FILE:
                this.controller = value;
                break;
            case CONVERT_FILE:
                this.convert = value;
                break;
            default:
                break;
        }
    }

}
