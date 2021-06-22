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
        LocalDate date = LocalDate.now();
//        LocalDateTime endDate = now.plusDays(1).atStartOfDay().minusSeconds(1);
        LocalDateTime startDate = LocalDate.of(date.getYear(), date.getMonthValue(), 1).atStartOfDay();
        LocalDateTime endDate = date.with(TemporalAdjusters.lastDayOfMonth()).atStartOfDay().plusDays(1).minusSeconds(1);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(LocalDate.now().getYear());
    }
}
