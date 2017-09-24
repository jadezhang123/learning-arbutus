package own.jadezhang.learning.arbutus.common.utils;

import java.util.regex.Pattern;

/**
 * Created by Zhang Junwei on 2017/5/24.
 */
public class RegexUtil {
    private static final Pattern phonePattern = Pattern.compile("^1[0-9]{10}$");

    public static boolean isPhone(String value){
        return  phonePattern.matcher(value).matches();
    }

}
