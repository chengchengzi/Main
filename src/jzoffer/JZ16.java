package jzoffer;

public class JZ16 {
    /**
     * 面试题16. 数值的整数次方
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     *
     *
     *
     * 示例 1:
     *
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     *
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     *
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     *
     *
     * 说明:
     *
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     */

    /*
        解法1: O(N)
        思路：
            非递归，for进行n次x相乘
     */
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        double res = 1.0;
        boolean flag = true;
        if(n < 0){
            flag = false;
            n = -n;
        }
        for(int i = 0; i < n; i++){
            res *= x;
        }
        if(!flag){
            res = 1 / res;
        }
        return res;
    }

    /*
        解法2：快速幂法,O(logN)
        思路：
            https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/

     */
    public double myPow2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b != 0) {
            if (b % 2 == 1) {
                res *= x;
            }
            x *= x;
            b = b / 2;
        }
        return res;
    }
}
