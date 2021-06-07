package com.base;

import java.math.BigDecimal;

/**
 * BigDecimal 学习
 *
 * @author djq
 * @date 2021/6/7 9:38
 */
public class ThinkingBigDecimal {
    public static void main(String[] args) {
        //精度运算
        PrecisionOperation();
    }
    /**
     * 精度运算
     */
    private static void PrecisionOperation() {
        BigDecimal amount1 = new BigDecimal(7).setScale(0);
        BigDecimal amount2 = new BigDecimal(3).setScale(0);
        BigDecimal roundUpAmount1 = amount1.divide(amount2,2,BigDecimal.ROUND_UP);
        BigDecimal roundUpAmount2 = amount1.divide(amount2,2,BigDecimal.ROUND_DOWN);
        BigDecimal roundUpAmount3 = amount1.divide(amount2,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(amount1);
        System.out.println(amount2);
        System.out.println(roundUpAmount1);
        System.out.println(roundUpAmount2);
        System.out.println(roundUpAmount3);
    }
}
