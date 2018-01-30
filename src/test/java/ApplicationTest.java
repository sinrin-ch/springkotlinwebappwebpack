import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.sinrin.demo.config.AppConfig;
import xyz.sinrin.demo.entity.TestBean;

public class ApplicationTest {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TestBean bean = context.getBean(TestBean.class);
        TestBean bean2 = context.getBean(TestBean.class);
//        System.out.println(bean);
        Assert.assertEquals("TestBean{}",bean.toString());
        Assert.assertSame(bean , bean2);
    }
}
