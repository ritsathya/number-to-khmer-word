package com.ritsathya.number_to_khmer_word.helpers;

import java.util.regex.Pattern;

public class Extension {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
