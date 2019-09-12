package com.analytics.common;

public class Constants {

    public static interface Controller {
        public static final String SALARY_REPORT = "report";
        public static final String INDEX_PAGE = "index";
        public static final String SPECIALIZATION_REQ_PARAM = "specialization";
        public static final String EXPERIENCE_REQ_PARAM = "experience";
    }

    public static interface Service {
        public static final String DEFAULT_SPECIALIZATION = "Java";
    }

    public static interface HeadHunter {
        public static final String DEVELOPMENT_SPECIALIZATION_ID = "1.221";
        public static final int MAX_QNT_VACANCIES_TO_SEARCH = 1000;
        public static final String MOSCOW_AREA_ID = "1";
        public static final int MAX_SEARCH_PERIOD_PER_DAY = 30;
    }

    public static interface Formatter {
        public static final int SCALE_THOUSANDS = -3;
    }
}
