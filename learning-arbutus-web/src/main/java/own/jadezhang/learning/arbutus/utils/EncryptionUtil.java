package own.jadezhang.learning.arbutus.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import own.jadezhang.base.common.utils.CommonUtil;

/**
 * Created by Zhang Junwei on 2017/5/14.
 */
public class EncryptionUtil {

    public static String MD5(String str) {
        SimpleHash md5 = new SimpleHash("MD5", str);
        return md5.toString();
    }

    public static String MD5(Object str, Object salt) {
        return MD5(str, salt, 1024);
    }

    /**
     * @param str            明文
     * @param salt           盐值；需要唯一
     * @param hashIterations hash次数
     * @return
     */
    public static String MD5(Object str, Object salt, int hashIterations) {
        SimpleHash md5 = new SimpleHash("MD5", str, salt, hashIterations);
        return md5.toString();
    }

    public static void main(String[] args) {

        String x = CommonUtil.makeUUID();
        String s = CommonUtil.makeUUID();
        System.out.println(s);
        System.out.println(x);

        System.out.println(EncryptionUtil.MD5("04093x", x));
    }
}
