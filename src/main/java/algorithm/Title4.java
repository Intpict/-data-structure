package algorithm;

/**
 * User: linsen
 * Date: 18/4/23
 * Time: 下午4:06
 * Description:
 */

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class Title4 {

    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return null;
        return str.toString().replace(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(new Title4().replaceSpace(new StringBuffer("We Are Happy")));
    }

}
