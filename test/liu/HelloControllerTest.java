package liu;

import liu.hello.HelloController;
import liu.spring.RootConfig;
import liu.spring.WebMvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


/**
 * Created by wtswindows7 on 2017/2/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class , WebMvcConfig.class})
@WebAppConfiguration
public class HelloControllerTest  {

    @Test
    public void testHelloPage() throws Exception{
        HelloController controller = new HelloController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/hello/world")).andExpect(view().name("hello"));

    }
}
