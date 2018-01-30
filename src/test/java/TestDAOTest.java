import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.sinrin.demo.config.AppConfig;
import xyz.sinrin.demo.config.DbConfig;
import xyz.sinrin.demo.dao.TestDAO;
import xyz.sinrin.demo.entity.TestBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestDAOTest {

    @Test
    public void testDAO(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TestDAO dao = context.getBean(TestDAO.class);
        dao.getAll().forEach(System.out::println);
    }

    @Test
    public void saveTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TestDAO dao = context.getBean(TestDAO.class);
        TestBean bean = new TestBean();
        bean.setBa("hahahahah");
        bean.setTa("heheheheh");
        dao.save(bean);
    }

    @Test
    public void saveListTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TestDAO dao = context.getBean(TestDAO.class);

        ArrayList<TestBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestBean bean = new TestBean();
            bean.setBa("666"+i);
            bean.setTa("777"+i);
            list.add(bean);
        }

        dao.saveList(list);
    }
}
