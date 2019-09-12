package com.analytics.controller;

import com.analytics.hh.Analyzer;
import com.analytics.hh.Report;
import com.analytics.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.yaal.project.hhapi.dictionary.Constants;

import static com.analytics.common.Constants.Controller.*;

@Controller
public class IndexController {

    @Autowired
    SpecializationService specializationService;

    @Autowired
    Analyzer analyzer;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        String topSpecialization = specializationService.getTopSpecializationName();
        Report report = analyzer.getSalaryReport(topSpecialization, Constants.Experience.BETWEEN_3_AND_6.getId());
        model.addAttribute(SALARY_REPORT, report);
        return INDEX_PAGE;
    }
}
