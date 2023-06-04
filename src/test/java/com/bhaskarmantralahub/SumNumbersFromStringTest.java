package com.bhaskarmantralahub;

import org.testng.annotations.Test;

public class SumNumbersFromStringTest {
    @Test
    public void sumNumbersFromString() {
       final String input = "Hello 1 Hola 2 Hi34";
       int total = 0;

       for (int i =0; i<input.length(); i++) {
            if (isCharacterNumeric(input.charAt(i))) {
                total += Character.getNumericValue(input.charAt(i));
            }
       }

       System.out.println(total);
    }

    public boolean isCharacterNumeric(Character character) {
        return Character.isDigit(character);
    }

}
