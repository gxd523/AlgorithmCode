package com.code.algorithm.other;

/**
 * 剑指题：17
 * 打印从1到最大的n位数
 * 如果返回字符串，就要考虑long都无法表示的大数
 */
public class PrintNumber {
    int[] result;// 反复强调，递归不方便携带的变量，可以写成成员变量
    char[] charArr;
    char[] charNumArr;
    int n;

    public int[] printNumbers(int n) {
        result = new int[(int) (Math.pow(10, n)) - 1];
        charArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        charNumArr = new char[n];
        this.n = n;

        generateDigital(1);
        return result;
    }

    private void generateDigital(int digital) {
        if (digital > n) {
            int value = Integer.parseInt(String.valueOf(charNumArr));// char数组转int值
            if (value != 0) {
                result[value - 1] = value;
            }
            return;
        }

        for (char c : charArr) {
            charNumArr[digital - 1] = c;
            generateDigital(digital + 1);// 看看这里如何运用递归
        }
    }
}