package ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import own.jadezhang.learning.arbutus.domain.auth.AuthUser;
import own.jadezhang.learning.arbutus.service.auth.IAuthUserService;

import java.util.List;

/**
 * Created by Zhang Junwei on 2017/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-ehcache.xml"})
public class SpringEhcacheDemo {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private IAuthUserService authUserService;

    @Test
    public void name() throws Exception {
        String phone = "15671569027";
        AuthUser user = authUserService.findByPrincipal(phone);
        AuthUser cachedUser = authUserService.findByPrincipal(phone);
        Assert.assertEquals(cachedUser.getName(), user.getName());
        phone = "15671569028";
        AuthUser anotherUser = authUserService.findByPrincipal(phone);

        Cache diskPersistentCache = cacheManager.getCache("diskPersistentCache");
        List keys = diskPersistentCache.getKeys();
        for (Object key : keys) {
            System.out.println(key);
            Element element = diskPersistentCache.get(key);
            System.out.println(element.getValue());
        }

        cacheManager.shutdown();
    }
}
