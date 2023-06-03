package com.bhaskarmantralahub.collections;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsPractice {
    public static void main(String[] args) {
//        final int[] intArr = {10, 12, 10, 30, 3, 1, 50};
//
////        System.out.println(Arrays.stream(intArr).max().getAsInt());
//
//        final Integer[] strArr1 = {10, 12, 10, 30, 3, 1, 50};
//
////        System.out.println(Collections.max(Arrays.asList(strArr1)));
//
//        Integer[] object = ArrayUtils.toObject(intArr);
////        Arrays.stream(object).forEach(System.out::println);
//
//        String[] strArr = {"Hello", "Hey", "Bhaskar", "Mounika", "Vedanth"};
//
////        Arrays.stream(strArr).sorted(String::compareTo).forEach(System.out::println);
//        Arrays.stream(object).sorted(Comparator.reverseOrder()).forEach(System.out::println);
////        Arrays.sort(object);
//
////        Arrays.stream(object).forEach(System.out::println);
//
////        Arrays.sort(strArr);
//
////        Arrays.stream(strArr).forEach(System.out::println);

        final Integer[] intArr = {10, 12, 10, 30, 3, 1, 50};

        Arrays.stream(intArr).sorted().forEach(System.out::println);
    }
}
