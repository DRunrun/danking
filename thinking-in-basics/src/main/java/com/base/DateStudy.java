package com.base;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;


/**
 *
 *
 * @author djq
 * @date 2021/6/18 15:30
 */
public class DateStudy {
    public static void main(String[] args) {
        LocalDateStudy();
    }

    private static void LocalDateStudy() {


        //startOfDay();
        yesDay();
        //nowDay();
        LocalDate date = LocalDate.now();
//        LocalDateTime endDate = now.plusDays(1).atStartOfDay().minusSeconds(1);
//        LocalDateTime startDate = LocalDate.of(date.getYear(), date.getMonthValue(), 1).atStartOfDay();
//        LocalDateTime endDate = date.with(TemporalAdjusters.lastDayOfMonth()).atStartOfDay().plusDays(1).minusSeconds(1);
//        System.out.println(startDate);
//        System.out.println(endDate);
//        System.out.println(LocalDate.now().getYear());
    }

    private static void nowDay() {
        LocalDateTime start=  LocalDate.now().atStartOfDay().minusSeconds(1);
        LocalDateTime end=LocalDate.now().minusDays(1).atStartOfDay();
        System.out.println(start);
        System.out.println(end);
    }

    private static void yesDay() {
        String yesterday = LocalDate.now().minusDays(1).toString().replaceAll("-", "");
        System.out.println(yesterday);
        LocalDateTime todayDateTime = LocalDate.now().atStartOfDay();
        System.out.println(todayDateTime);
        LocalDateTime localDateTime = LocalDateTime.of(2021, 7, 2, 00, 00, 00);
        System.out.println(localDateTime);
        System.out.println(LocalDate.now().toString());


    }

    private static void startOfDay() {

        LocalDateTime todayDateTime = LocalDate.now().atStartOfDay();
        System.out.println(todayDateTime);
        System.out.println(todayDateTime.minusDays(1));
        System.out.println(todayDateTime.minusSeconds(1));


    }
}
