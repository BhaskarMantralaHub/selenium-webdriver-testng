package com.bhaskarmantralahub;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class CubesTest {

    @Test
    public void findMinWeightCube() {
        Double[] cubeWeightArray = {30d, 30d, 30d, 30d, 20d, 30d};
        System.out.println(Arrays.stream(cubeWeightArray).min(Double::compareTo).get());
    }

    @Test
    public void findMinWeightCubeUsingCollections() {
        Double[] cubeWeightArray = {30d, 30d, 30d, 30d, 20d, 30d};
        System.out.println(Collections.min(Arrays.asList(cubeWeightArray)));
    }

    @Test
    public void findMinWeightCubeUsingForLoop() {
        Double[] cubeWeightArray = {30d, 30d, 30d, 30d, 20d, 30d, 10d};
        Double min = null;
        for (int i = 0; i < cubeWeightArray.length-1; i++) {
            min = Math.min(cubeWeightArray[i], cubeWeightArray[i+1]);
        }

        System.out.println(min);
    }

}
