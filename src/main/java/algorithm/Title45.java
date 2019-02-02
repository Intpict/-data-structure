package algorithm;

/**
 * User: linsen
 * Date: 18/5/7
 * Time: 下午11:40
 * Description:
 */

/**
 * “student. a am I” 单词翻转 “I am a student.”。
 */
public class Title45 {

    public class Solution {
        public String ReverseSentence(String str) {
            if (str == null)
                return null;
            if (str.trim().equals("")) {
                return str;
            }
            String string = str;
            String[] strings = string.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = strings.length - 1; i >= 0; i--) {
                if (i == 0) {
                    sb.append(strings[i]);
                } else {
                    sb.append(strings[i]);
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
    }


}
