package com.analytics.common;

import java.util.Arrays;

public class MathUtils {

    public static double median(double[] numbers) {
        Arrays.sort(numbers, 0, numbers.length);
        int middle = numbers.length / 2;
        if (numbers.length % 2 == 1) {
            return numbers[middle];
        } else {
            return (numbers[middle - 1] + numbers[middle]) / 2.0;
        }
    }
}
