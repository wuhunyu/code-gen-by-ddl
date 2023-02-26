package top.wuhunyu.codegenbyddl.template.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.wuhunyu.codegenbyddl.core.anna.NotNull;

import java.io.Serializable;
import java.util.List;

/**
 * 模板Dto
 *
 * @author wuhunyu
 * @date 2023/02/13 10:55
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateDto implements Serializable {

    private static final long serialVersionUID = 202428862454804466L;

    /**
     * 表信息
     */
    @NotNull
    private EntityTemplateDto entityTemplate;

    /**
     * 表字段信息
     */
    @NotNull
    private List<EntityFiledTemplateDto> entityFiledTemplates;

}
