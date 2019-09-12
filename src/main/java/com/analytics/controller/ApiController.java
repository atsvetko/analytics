package com.analytics.controller;

import com.analytics.hh.Analyzer;
import com.analytics.hh.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.analytics.common.Constants.Controller.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    Analyzer analyzer;

    @GetMapping("/salary")
    public Report getSalaryReport(HttpServletRequest request) {
        return analyzer.getSalaryReport(
                request.getParameter(SPECIALIZATION_REQ_PARAM),
                request.getParameter(EXPERIENCE_REQ_PARAM)
        );
    }
}
