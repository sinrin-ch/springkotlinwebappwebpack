import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import xyz.sinrin.demo.config.AppConfig;
import xyz.sinrin.demo.config.DbConfig;

import javax.sql.DataSource;

@RunWith(BlockJUnit4ClassRunner.class)
public class JDBCTemplateTest {


    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        DriverManagerDataSource dataSource = (DriverManagerDataSource)context.getBean(DataSource.class);
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        dataSource.setUrl("jdbc:sqlserver://dgov1:1433;DatabaseName=PBS_test");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("Aztech.com1985");

//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String sql = "select * from test";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        String ba;
        String ta;
        while (sqlRowSet.next()) {
            ba = sqlRowSet.getString("ba");
            ta = sqlRowSet.getString("ta");
            System.out.println(ba);
            System.out.println(ta);
            System.out.println("=====================================");
        }

    }
}
