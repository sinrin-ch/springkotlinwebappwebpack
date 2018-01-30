import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import xyz.sinrin.demo.config.AppConfig
import xyz.sinrin.demo.dao.TestDAO
import xyz.sinrin.demo.entity.TestBean
import java.util.ArrayList

class TestDAO2Test {

    @Test
    fun saveListTest() {
        val context = AnnotationConfigApplicationContext(AppConfig::class.java)
        val dao: TestDAO = context.getBean(TestDAO::class.java)

        val list = ArrayList<TestBean>()
        for (i in 21..30) {
            val bean = TestBean()
            bean.ba = "666" + i
            bean.ta = "777" + i
            list.add(bean)
        }

        dao.saveList(list)
    }
}