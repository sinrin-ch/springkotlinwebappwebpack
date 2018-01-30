package xyz.sinrin.demo;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import xyz.sinrin.demo.config.AppConfig;
import xyz.sinrin.demo.config.WebConfig;

/**
 * WebApp的启动类,初始化DispatherServlet，代替在web.xml中到DispatherServlet配置,
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @NotNull
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    /**
     * 加载spring mvc配置
     */
    @NotNull
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @NotNull
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
