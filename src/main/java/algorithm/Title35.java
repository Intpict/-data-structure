package algorithm;

/**
 * User: linsen
 * Date: 18/5/3
 * Time: 上午9:09
 * Description:
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置
 */
public class Title35 {

    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                map.put(str.charAt(i), 1);
        }
        for (int i = 0; i < str.length(); i++)
            if (map.get(str.charAt(i)) == 1)
                return i;

        return 0;
    }

}
