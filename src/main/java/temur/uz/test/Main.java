package temur.uz.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "LVIII";

        System.out.println(romanToInt(s));

    }

    public static int romanToInt(String s) {
        int res = 0;
        int nums = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch (s.charAt(i)){
                case 'I': nums = 1; break;
                case 'V': nums = 5; break;
                case 'X': nums = 10; break;
                case 'L': nums = 50; break;
                case 'C': nums = 100; break;
                case 'D': nums = 500; break;
                case 'M': nums = 1000; break;
            }
            if (4*nums<res) res -= nums;
            else res += nums;
        }

        return res;
    }
}
