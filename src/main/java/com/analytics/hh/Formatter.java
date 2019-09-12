package com.analytics.hh;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Component;

import static com.analytics.common.Constants.Formatter.*;

@Component
public class Formatter {

    public String getThousands(double number) {
        return String.valueOf(getRounded(number) / 1000);
    }

    public String getSeparated(double number) {
        return String.format("%,d", getRounded(number));
    }

    private int getRounded(double number) {
        Double roundedNumber = Precision.round(number, SCALE_THOUSANDS);
        return roundedNumber.intValue();
    }
}
