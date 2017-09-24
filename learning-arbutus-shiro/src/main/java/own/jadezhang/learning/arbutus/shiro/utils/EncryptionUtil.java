package own.jadezhang.learning.arbutus.shiro.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

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
        System.out.println(EncryptionUtil.MD5("04093x", "15671569027"));
    }
}
