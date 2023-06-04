package com.bhaskarmantralahub;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringByLengthTest {

    @Test
    public void sumNumbersFromString() {
        final String[] input = {"may", "august", "april", "june"};
        Arrays.stream(input).sorted((a, b) -> Integer.compare(a.length(), b.length())).forEach(System.out::println);
    }
}
