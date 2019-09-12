package com.analytics.hh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    private int vacancyCount;
    private SalaryStatistic salaryStatistic;
}
