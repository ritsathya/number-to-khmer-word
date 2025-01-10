package com.ritsathya.number_to_khmer_word.helpers;

import java.math.BigInteger;

import static com.ritsathya.number_to_khmer_word.helpers.Constant.*;

public class IntegerConversion {

    public String integerToWord(BigInteger number) {
        String word = "";
        BigInteger remainder = new BigInteger("0");

        if (number.compareTo(TEN) < 0) {
            word = SINGLE_DIGIT[number.intValue()];

        } else if (number.compareTo(ONE_HUNDRED) < 0) {
            remainder = number.mod(TEN);
            word = DOUBLE_DIGIT[number.divide(TEN).intValue()];

        } else if (number.compareTo(ONE_THOUSAND) < 0) {
            remainder = number.mod(ONE_HUNDRED);
            word = SINGLE_DIGIT[number.divide(ONE_HUNDRED).intValue()] + WORDS.get("HUNDRED");

        } else if (number.compareTo(TEN_THOUSAND) < 0) {
            remainder = number.mod(ONE_HUNDRED);
//            word = SINGLE_DIGIT[number.divide(ONE_THOUSAND).intValue()] + WORDS.get("THOUSAND");
            word = integerToWord(number.divide(ONE_HUNDRED)) + WORDS.get("HUNDRED");


        } else if (number.compareTo(ONE_HUNDRED_THOUSAND) < 0) {
            remainder = number.mod(ONE_THOUSAND);
//            word = SINGLE_DIGIT[number.divide(TEN_THOUSAND).intValue()] + WORDS.get("TEN_THOUSAND");
            word = integerToWord(number.divide(ONE_THOUSAND)) + WORDS.get("THOUSAND");

        } else if (number.compareTo(ONE_MILLION) < 0) {
            remainder = number.mod(ONE_THOUSAND);
//            word = SINGLE_DIGIT[number.divide(ONE_HUNDRED_THOUSAND).intValue()] + WORDS.get("HUNDRED_THOUSAND");
            word = integerToWord(number.divide(ONE_THOUSAND)) + WORDS.get("THOUSAND");


        } else if (number.compareTo(ONE_BILLION) < 0) {
            remainder = number.mod(ONE_MILLION);
            word = integerToWord(number.divide(ONE_MILLION)) + WORDS.get("MILLION");

        } else if (number.compareTo(ONE_TRILLION) < 0) {
            remainder = number.mod(ONE_BILLION);
            word = integerToWord(number.divide(ONE_BILLION)) + WORDS.get("BILLION");

        } else if (number.compareTo(ONE_QUADRILLION) < 0) {
            remainder = number.mod(ONE_TRILLION);
            word = integerToWord(number.divide(ONE_TRILLION)) + WORDS.get("TRILLION");

        }

        if (remainder.compareTo(BigInteger.ZERO) != 0) {
            return word + SEPARATOR + integerToWord(remainder);
        }

        return word;
    }
}
