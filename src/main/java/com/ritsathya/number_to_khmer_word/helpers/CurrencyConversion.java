package com.ritsathya.number_to_khmer_word.helpers;

import java.math.BigInteger;

import static com.ritsathya.number_to_khmer_word.helpers.Constant.*;
import static com.ritsathya.number_to_khmer_word.helpers.Extension.isNumeric;

public class CurrencyConversion {

    public String currencyToWord(String input, String currency) {
        if (!isNumeric(input)) {
            return "The number format is invalid";
        }

        String currencyName = CURRENCY_NAMES.get(currency);
        String result;
        try {
            BigInteger number = new BigInteger(input);
            result = handleInteger(number, currencyName);
        } catch (NumberFormatException nfe) {
            result = handleDecimal(input, currencyName);
        }

        return currency + ": " + result;
    }

    public String handleInteger(BigInteger number, String currencyName) {
        String integerPart = new IntegerConversion().integerToWord(number);
        return integerPart + currencyName + SHARP_WORD;
    }

    public String handleDecimal(String input, String currencyName) {
        IntegerConversion conversion = new IntegerConversion();
        String[] parts = input.split("\\.");

        String integer = parts[0];
        String integerPart = conversion.integerToWord(new BigInteger(integer));

        String decimal = parts.length > 1 ? parts[1] : "";
        if (decimal.length() <= 2) {
            // handle 0.5 => 0.50, retain 0
            // fifty instead of five CentWord
            if (decimal.length() == 1) {
                decimal = decimal + "0";
            }

            String decimalPart = conversion.integerToWord(new BigInteger(decimal));
            return integerPart + currencyName + AND_WORD + decimalPart + CENT_WORD;
        } else {
            String number = new NumberConversion().numberToWord(input);
            return number + currencyName;
        }
    }
}
