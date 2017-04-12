package liu;

import liu.hello.HelloController;
import liu.spring.RootConfig;
import liu.spring.WebMvcConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
@ContextConfiguration(classes = RootConfig.class)
@WebAppConfiguration
public class KafkaTest  {

    @Autowired
    private KafkaTemplate<Integer, String> template;

    @Test
    public void testKafka() throws Exception{

        template.send("test", "testtest111");
        template.flush();

    }
}
