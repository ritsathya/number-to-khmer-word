package com.ritsathya.number_to_khmer_word.helpers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final String SEPARATOR = "";
    public static final String[] SINGLE_DIGIT = {"សូន្យ", "មួយ", "ពីរ", "បី", "បួន", "ប្រាំ", "ប្រាំមួយ", "ប្រាំពីរ", "ប្រាំបី", "ប្រាំបួន"};
    public static final String[] DOUBLE_DIGIT = {"", "ដប់", "ម្ភៃ", "សាមសិប", "សែសិប", "ហាសិប", "ហុកសិប", "ចិតសិប", "ប៉ែតសិប", "កៅសិប"};

    public static final Map<String, String> WORDS;

    static {
        WORDS = new HashMap<>();
        WORDS.put("HUNDRED", "រយ");
        WORDS.put("THOUSAND", "ពាន់");
        WORDS.put("TEN_THOUSAND", "ម៉ឺន");
        WORDS.put("HUNDRED_THOUSAND", "សែន");
        WORDS.put("MILLION", "លាន");
        WORDS.put("BILLION", "ប៊ីលាន");
        WORDS.put("TRILLION", "ទ្រីលាន");
    }

    public static final BigInteger TEN = new BigInteger("10");
    public static final BigInteger ONE_HUNDRED = new BigInteger("100");
    public static final BigInteger ONE_THOUSAND = new BigInteger("1000");
    public static final BigInteger TEN_THOUSAND = new BigInteger("10000");
    public static final BigInteger ONE_HUNDRED_THOUSAND = new BigInteger("100000");
    public static final BigInteger ONE_MILLION = new BigInteger("1000000");
    public static final BigInteger ONE_BILLION = new BigInteger("1000000000");
    public static final BigInteger ONE_TRILLION = new BigInteger("1000000000000");
    public static final BigInteger ONE_QUADRILLION = new BigInteger("1000000000000000");

    public static final Map<String, String> DECIMAL_SYMBOLS;

    static {
        DECIMAL_SYMBOLS = new HashMap<>();
        DECIMAL_SYMBOLS.put("DECIMAL_POINT", "ចុច");
        DECIMAL_SYMBOLS.put("DECIMAL_COMMA", "ក្បៀស");
    }

    public static final String AND_WORD = "និង";
    public static final String SHARP_WORD = "គត់";
    public static final String CENT_WORD = "សេន";

    public static final Map<String, String> CURRENCY_NAMES;

    static {
        CURRENCY_NAMES = new HashMap<>();
        CURRENCY_NAMES.put("KHR", "រៀល");
        CURRENCY_NAMES.put("USD", "ដុល្លារ");
    }
}
