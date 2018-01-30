package xyz.sinrin.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:/jdbc.properties",encoding = "utf-8")
public class DbConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

//    @Autowired
//    private Environment env;
    /**
     * 数据源
     */
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url,username,password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    /**
     * jdbcTemplate 模板 ,spring会自动注入数据源
     * @param dataSource 数据源
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
//        DataSource dataSource = dataSource();
        return new JdbcTemplate(dataSource);
    }
}
