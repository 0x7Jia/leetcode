package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author echo
 * @version V1.0
 * @Package challenge
 * @date 2020/9/20 11:01
 * @leetCode
 *
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 */
public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();

        do {
            findAllDigits(low, high, res);
            low = getLessInteger(low);
        }while ( low <= high);

        return res.stream().distinct().collect(Collectors.toList());
    }

    private static void findAllDigits(int low, int high, List<Integer> res) {
        int start = getHighDigits(low);
        int i = 0;
        StringBuilder sb = new StringBuilder();
        String lowStr = String.valueOf(low);
        while (++i<=lowStr.length()){
            if (start==10){
                return;
            }
            sb.append(start++);
        }

        int value = Integer.parseInt(sb.toString());

        if (value>=low && value<=high){
            res.add(value);
        }
    }

    private static int getHighDigits(int n){
        if (n>=100000000) n/=100000000;
        if (n>=10000) n/=10000;
        if (n>=100) n/=100;
        if (n>=10) n/=10;
        return n;
    }

    private static int getLessInteger(int base){
        String baseStr = String.valueOf(base);
        int start = getHighDigits(base);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 1;
        sb1.append(1);
        sb2.append(start);
        while (++i <= baseStr.length()){
            sb1.append(0);
            sb2.append(0);
        }

        return Integer.parseInt(sb1.toString())+Integer.parseInt(sb2.toString());
    }

    public static void main(String[] args) {
//        System.out.println(sequentialDigits(100, 500));
//        System.out.println(sequentialDigits(200, 500));
//        System.out.println(sequentialDigits(340, 500));
//        System.out.println(sequentialDigits(650, 500));
//        System.out.println(sequentialDigits(1000, 13000));
//        System.out.println(sequentialDigits(10, 1000000000));
        System.out.println(sequentialDigits(58, 155));
    }

}
