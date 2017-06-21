package schedule;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Zhang Junwei on 2017/5/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:schedule.xml"})
public class ScheduleTester {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleTester.class);


    @Autowired
    TBScheduleManagerFactory scheduleManagerFactory;

    @Test
    public void test() throws Exception {
        logger.debug("test.....");
        scheduleManagerFactory.init();
        Thread.sleep(100000000000000000L);
    }
}
