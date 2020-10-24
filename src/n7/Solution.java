package n7;

/**
 * @author echo
 * @version V1.0
 * @Package n7
 * @date 2020/9/27 15:34
 */
public class Solution {
    public static int reverse(int x) {
        String xReverseStr = new StringBuilder(String.valueOf(x)).reverse().toString();
        StringBuilder sb = new StringBuilder();
        if (x < 0){
            sb.append("-");
        }

        int realLen = x>0 ? xReverseStr.length() : xReverseStr.length()-1;

        char[] charArr = xReverseStr.toCharArray();
        int noneZeroIndex = 0;
        for (char ch:charArr){
            if (ch != '0') break;
            noneZeroIndex++;
        }

        for (int i = noneZeroIndex; i<realLen; ++i){
            sb.append(charArr[i]);
        }

        try {
            return Integer.parseInt(sb.toString());
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-8760));
        System.out.println(reverse(6660));
        System.out.println(reverse(2147483647));
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(123));
        System.out.println(reverse(120));
        System.out.println(reverse(-132));
        System.out.println(reverse(0));
    }
}
