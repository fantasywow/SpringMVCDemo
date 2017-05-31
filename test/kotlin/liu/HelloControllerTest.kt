package liu

import liu.hello.HelloController
import liu.spring.RootConfig
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup


/**
 * Created by wtswindows7 on 2017/2/16.
 */

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = arrayOf(RootConfig::class))
@WebAppConfiguration
class HelloControllerKotlinTest {

    @Autowired
    internal var controller: HelloController? = null

    @Test
    @Throws(Exception::class)
    fun testHelloPage() {

        val mockMvc = standaloneSetup(controller).build()
        mockMvc.perform(get("/hello/world")).andExpect(view().name("hello"))

    }
}
