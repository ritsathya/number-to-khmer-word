package com.ritsathya.number_to_khmer_word;

import com.ritsathya.number_to_khmer_word.helpers.CurrencyConversion;
import com.ritsathya.number_to_khmer_word.helpers.NumberConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class NumberConversionController {

    @GetMapping("/number-to-word")
    public String numberToWord(@RequestParam(value = "number", defaultValue = "") String number) {
        NumberConversion conversion = new NumberConversion();
        return conversion.numberToWord(number);
    }

    @GetMapping("/currency-to-word")
    public String currencyToWord(@RequestParam(value = "input", defaultValue = "") String input, @RequestParam(value = "currency", defaultValue = "") String currency) {
        CurrencyConversion conversion = new CurrencyConversion();
        return conversion.currencyToWord(input, currency);
    }
}
