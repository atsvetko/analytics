package com.analytics.hh;

import org.springframework.stereotype.Component;
import ru.yaal.project.hhapi.dictionary.Constants;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.proffield.ProfField;
import ru.yaal.project.hhapi.search.ISearch;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.parameter.Period;
import ru.yaal.project.hhapi.search.parameter.Text;
import ru.yaal.project.hhapi.vacancy.Vacancy;
import ru.yaal.project.hhapi.vacancy.VacancyList;
import ru.yaal.project.hhapi.vacancy.VacancySearch;

import static com.analytics.common.Constants.HeadHunter.*;

import java.util.List;

@Component
public class HeadHunter {

    public List<Vacancy> getVacanciesInMoscow(String keyword, String experienceId) throws SearchException {
        ISearchParameter text = new Text(keyword);
        Area area = new Area();
        area.setId(MOSCOW_AREA_ID);
        ISearchParameter profField = ProfField.PROF_FIELDS.getById(DEVELOPMENT_SPECIALIZATION_ID);
        ISearchParameter experience = Constants.Experience.EXPERIENCES.getById(experienceId);
        ISearchParameter onlyWithSalary = Constants.OnlyWithSalary.ON;
        ISearchParameter period = new Period(MAX_SEARCH_PERIOD_PER_DAY);
        ISearch<VacancyList> search = new VacancySearch(MAX_QNT_VACANCIES_TO_SEARCH)
                .addParameter(text)
                .addParameter(area)
                .addParameter(onlyWithSalary)
                .addParameter(profField)
                .addParameter(period)
                .addParameter(experience);
        return search.search();
    }
}
