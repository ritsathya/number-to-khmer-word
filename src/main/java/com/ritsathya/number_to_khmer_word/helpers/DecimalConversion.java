package com.ritsathya.number_to_khmer_word.helpers;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ritsathya.number_to_khmer_word.helpers.Constant.*;

public class DecimalConversion {

    public String decimalToWord(String number) {
        String[] numArr = number.split("");
        Stream<String> digitArr = Arrays.stream(numArr).map(c -> SEPARATOR + SINGLE_DIGIT[Integer.parseInt(c)]);
        return digitArr.collect(Collectors.joining(""));
    }

    public String handleDecimal(String input) {
        String[] parts = input.split("\\.");
        String integer = parts[0];
        String decimal = parts.length > 1 ? parts[1] : "";

        String integerPart = new IntegerConversion().integerToWord(new BigInteger(integer));
        String decimalPart = decimalToWord(decimal);
        return integerPart + DECIMAL_SYMBOLS.get("DECIMAL_COMMA") + decimalPart;
    }
}
