package ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Zhang Junwei on 2017/6/15 0015.
 */

public class EhcacheDemo {

    @Test
    public void test() throws Exception {

        CacheManager cacheManager = CacheManager.create(this.getClass().getClassLoader().getResourceAsStream("ehcache-disk.xml"));
        String[] cacheNames = cacheManager.getCacheNames();
        for (String cacheName : cacheNames) {
            System.out.println(cacheName);
        }
        Cache cache = cacheManager.getCache("cacheDisk");
        Element element = new Element("firstKey", "firstValue");
        cache.put(element);
        List keys = cache.getKeys();
        System.out.println(keys.size());
        Element fromCache = cache.get("firstKey");
        Assert.assertNotNull(fromCache);
        Assert.assertEquals("firstValue", fromCache.getValue());

    }
}
