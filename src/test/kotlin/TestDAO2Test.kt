import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import xyz.sinrin.demo.config.AppConfig
import xyz.sinrin.demo.dao.TestDAO
import xyz.sinrin.demo.entity.TestBean
import java.util.ArrayList
import java.util.function.Consumer

class TestDAO2Test {

    @Test
    fun testDAO() {
        val context = AnnotationConfigApplicationContext(AppConfig::class.java)
        val dao = context.getBean(TestDAO::class.java)
//        dao.all.forEach(Consumer<TestBean> { println(it) })
//        dao.all.forEach { println(it) }
        val list: List<TestBean> = dao.all
//        list.filter { it.ba?.endsWith("0")?:false }.forEach { println(it) }
        list.lastOrNull { it.ba?.endsWith("2")?:false  }?.let { println(it.ba) }
//        list.map { it.ba }.forEach { it?.let { println(it.length) } }  // 如果是null,不执行后面的println
//        var str:String? = null;
//        str?.let { println(it.length) }
    }
}