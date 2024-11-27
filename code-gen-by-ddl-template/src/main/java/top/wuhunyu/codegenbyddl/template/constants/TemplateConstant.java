package top.wuhunyu.codegenbyddl.template.constants;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 模板常量
 *
 * @author wuhunyu
 * @date 2023/02/13 09:54
 **/

public final class TemplateConstant {

    private TemplateConstant() {
    }

    /**
     * 实体类
     */
    public static final String ENTITY_FILE = "entity.ftl";

    /**
     * mapper 接口
     */
    public static final String MAPPER_INTERFACE_FILE = "mapper.ftl";

    /**
     * mapper xml
     */
    public static final String MAPPER_XML_FILE = "mapperXml.ftl";

    /**
     * service 接口
     */
    public static final String SERVICE_FILE = "service.ftl";

    /**
     * service 接口实现类
     */
    public static final String SERVICE_IMPL_FILE = "serviceImpl.ftl";

    /**
     * controller
     */
    public static final String CONTROLLER_FILE = "controller.ftl";

    /**
     * convert 转换器
     */
    public static final String CONVERT_FILE = "convert.ftl";

    /**
     * 模板文件集合
     */
    public static final Set<String> TEMPLATE_NAMES;

    static {
        // 记录所有的模板文件名称
        Set<String> set = new HashSet<String>(7) {{
            add(ENTITY_FILE);
            add(MAPPER_INTERFACE_FILE);
            add(MAPPER_XML_FILE);
            add(SERVICE_FILE);
            add(SERVICE_IMPL_FILE);
            add(CONTROLLER_FILE);
            add(CONVERT_FILE);
        }};
        // 转成不可变 set
        TEMPLATE_NAMES = Collections.unmodifiableSet(set);
    }

}
