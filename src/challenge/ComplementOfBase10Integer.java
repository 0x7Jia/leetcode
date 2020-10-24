package challenge;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/10/5 16:40
 * @leetCode 1009
 */
public class ComplementOfBase10Integer {

    /**
     * 给定一个非负整数求其对应二进制取反后的十进制值
     * @param N 非负整数
     * @return 二进制取反后的十进制值
     */
    public static int bitwiseComplement(int N) {
        String binStr = Integer.toBinaryString(N).chars().mapToObj(t -> t - '0')
                .map(t -> t == 0 ? "1" : "0").collect(Collectors.joining(""));

        return Integer.valueOf(binStr, 2);
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(7));
        System.out.println(bitwiseComplement(5));
        System.out.println(bitwiseComplement(10));
        System.out.println(bitwiseComplement(110));
        System.out.println(bitwiseComplement(100));
    }
}
