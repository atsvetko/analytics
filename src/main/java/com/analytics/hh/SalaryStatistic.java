package com.analytics.hh;

import lombok.Data;

@Data
public class SalaryStatistic {

    private String minimal;
    private String maximum;
    private String median;
    private String average;
    private String twentyFivePercentile;
    private String seventyFivePercentile;
}
