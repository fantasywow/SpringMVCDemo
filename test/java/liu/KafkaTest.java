package liu;

import liu.spring.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


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
