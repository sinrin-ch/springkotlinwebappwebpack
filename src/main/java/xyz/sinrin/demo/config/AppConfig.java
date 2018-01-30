package xyz.sinrin.demo.config;

import org.springframework.context.annotation.*;
import xyz.sinrin.demo.entity.TestBean;

@Configuration
// 配置spring扫描的路径
@ComponentScan(basePackages = "xyz.sinrin.demo")
//@Import({DbConfig.class,WebConfig.class})
public class AppConfig {
//    @Bean
//    @Scope("prototype")
//    public TestBean testBean(){
//        return new TestBean();
//    }

//    @Bean("configProperties")
//    public PropertiesFactoryBean propertiesFactoryBean(){
//        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        propertiesFactoryBean.setFileEncoding("utf-8");
//    }
}
