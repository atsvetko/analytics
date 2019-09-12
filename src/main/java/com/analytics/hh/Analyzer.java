package com.analytics.hh;

import com.analytics.common.MathUtils;
import org.apache.commons.math3.stat.StatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yaal.project.hhapi.dictionary.Constants;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.vacancy.Salary;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import java.util.List;

@Component
public class Analyzer {

    @Autowired
    HeadHunter headHunter;

    @Autowired
    Formatter formatter;

    public Report getSalaryReport(String keyword, String experienceId) {
        Report report = new Report();
        try {
            List<Vacancy> vacancies = headHunter.getVacanciesInMoscow(keyword, experienceId);
            double[] salaries = getRublesSalaries(vacancies);
            report.setVacancyCount(salaries.length);
            report.setSalaryStatistic(getSalaryStatistic(salaries));
        } catch (SearchException e) {
            e.printStackTrace();
        }
        return report;
    }

    private SalaryStatistic getSalaryStatistic(double[] salaries) {
        SalaryStatistic statistic = new SalaryStatistic();
        statistic.setMaximum(formatter.getThousands(StatUtils.max(salaries)));
        statistic.setMinimal(formatter.getThousands(StatUtils.min(salaries)));
        statistic.setMedian(formatter.getThousands(MathUtils.median(salaries)));
        statistic.setAverage(formatter.getSeparated(StatUtils.mean(salaries)));
        statistic.setTwentyFivePercentile(formatter.getThousands(StatUtils.percentile(salaries, 25)));
        statistic.setSeventyFivePercentile(formatter.getThousands(StatUtils.percentile(salaries, 75)));
        return statistic;
    }

    private double[] getRublesSalaries(List<Vacancy> vacancies) {
        return vacancies.stream()
                .filter(this::isRublesSalary)
                .mapToDouble(vacancy -> getAverageSalary(vacancy.getSalary()))
                .filter(i -> i != -1)
                .toArray();
    }

    private boolean isRublesSalary(Vacancy vacancy) {
        return vacancy.getSalary().getCurrency().equals(Constants.Currency.RUR);
    }

    private double getAverageSalary(Salary salary) {
        if (salary.getFrom() != null) {
            if (salary.getTo() != null) {
                return (salary.getFrom() * 1.0 + salary.getTo()) / 2;
            }
            return salary.getFrom();
        }
        return salary.getTo() != null ? salary.getTo() : -1;
    }
}
