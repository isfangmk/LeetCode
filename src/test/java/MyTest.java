import org.junit.Test;

/**
 * @author fmk
 * @date 2020/8/10 14:16
 */
public class MyTest {
    @Test
    public void test() {
        System.out.println(addBinary("1010", "1011"));
    }
    public String addBinary(String a, String b) {

        StringBuilder res = new StringBuilder();
        int carry = 0, sum = 0, i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int v1 = i < 0 ? 0 : a.charAt(i) - '0';
            int v2 = j < 0 ? 0 : b.charAt(j) - '0';
            sum = carry + v1 + v2;
            carry = sum / 2;
            res.append(sum % 2);
            i--;
            j--;
        }
        return res.reverse().toString();
    }
}
