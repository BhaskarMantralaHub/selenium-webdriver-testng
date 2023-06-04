package com.bhaskarmantralahub;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringByLengthTest {

    @Test
    public void sumNumbersFromString() {
        final String[] input = {"may", "august", "april", "june"};
        Arrays.stream(input).sorted((a, b) -> {
            if (a.length() > b.length()) return 1;
            else if (a.length() < b.length()) return -1;
            return 0;
        }).forEach(System.out::println);
    }
}
