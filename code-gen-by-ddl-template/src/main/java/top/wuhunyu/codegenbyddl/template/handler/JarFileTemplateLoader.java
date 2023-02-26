package top.wuhunyu.codegenbyddl.template.handler;

import freemarker.cache.TemplateLoader;
import lombok.extern.slf4j.Slf4j;
import top.wuhunyu.codegenbyddl.template.utils.StrUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * jar 包资源文件加载
 *
 * @author wuhunyu
 * @version 1.0
 * @date 2023/2/15 22:59
 */

@Slf4j
public class JarFileTemplateLoader implements TemplateLoader {

    private final String path;

    /**
     * 模板文件名称
     */
    private final ThreadLocal<String> fileNameMap = new ThreadLocal<>() {
        @Override
        protected String initialValue() {
            // 初始化 空值
            return "";
        }
    };

    public JarFileTemplateLoader(String path) {
        this.path = path;
    }

    @Override
    public Object findTemplateSource(String path) throws IOException {
        // 资源全路径
        fileNameMap.set(path);
        log.debug("资源全路径: {}", path);
        return this;
    }

    @Override
    public long getLastModified(Object o) {
        // 由于 jar 文件不可变，也不需要支持热部署，直接返回固定值
        return 0L;
    }

    @Override
    public Reader getReader(Object o, String encoding) throws IOException {
        JarFileTemplateLoader jarFileTemplateLoader = (JarFileTemplateLoader) o;
        String finalPath = StrUtil.pathMerge(jarFileTemplateLoader.path, fileNameMap.get());
        log.debug("最终模板路径: {}", finalPath);
        return new InputStreamReader(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(finalPath));
    }

    @Override
    public void closeTemplateSource(Object o) throws IOException {
        // 移除
        fileNameMap.remove();
    }
}
