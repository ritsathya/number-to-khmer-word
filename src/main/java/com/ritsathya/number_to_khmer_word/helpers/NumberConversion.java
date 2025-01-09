package com.ritsathya.number_to_khmer_word.helpers;

import java.math.BigInteger;

import static com.ritsathya.number_to_khmer_word.helpers.Extension.isNumeric;

public class NumberConversion {

    public String numberToWord(String input) {
        if (!isNumeric(input)) {
            return "The number format is invalid";
        }

        try {
            BigInteger number = new BigInteger(input);
            return new IntegerConversion().integerToWord(number);
        } catch (NumberFormatException nfe) {
            return new DecimalConversion().handleDecimal(input);
        }
    }
}
