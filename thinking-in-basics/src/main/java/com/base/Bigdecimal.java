package com.base;

import java.math.BigDecimal;

/**
 * TODO: 
 *
 * @author djq
 * @date 2021/7/14 10:50
 */
public class Bigdecimal {
    public static void main(String[] args) {
        随机数();
    }

    private static void 随机数() {
        for (int i = 0; i < 50;i++){

            BigDecimal orderAmount = new BigDecimal(50.01);
            String param = "1-5";
            String[] values = param.split("[-]");
            BigDecimal topValue = new BigDecimal(values[1]).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal valleyValue = new BigDecimal(values[0]).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal min = topValue.subtract(valleyValue);
            BigDecimal randomPercent = (min.multiply(new BigDecimal((Math.random())))
                    .add(valleyValue)).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal littleRandom = randomPercent.divide(new BigDecimal(100))
                    .setScale(4, BigDecimal.ROUND_HALF_UP);
            BigDecimal littleRandom1 = randomPercent.divide(new BigDecimal(100))
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal rewardAmount = orderAmount.multiply(littleRandom).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal rewardAmount1 = orderAmount.multiply(littleRandom1).setScale(2, BigDecimal.ROUND_HALF_UP);

            System.out.println("订单金额："+orderAmount);
            System.out.println("限制上限："+topValue);
            System.out.println("限制下限："+valleyValue);
            System.out.println("获取到的概率值"+randomPercent);
            System.out.println("最终奖励的金额"+rewardAmount);
            System.out.println("原最终奖励的金额"+rewardAmount1);
            System.out.println("---------------------------------------");
           /* System.out.println(min);
            System.out.println(randomPercent);
            System.out.println(littleRandom);
            System.out.println(rewardAmount);*/
        }


    }
}
