package com.example.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;

@Controller
public class Calculator {

    static void check(double p, double yr, int m) {
        if (p <= 0 || yr <= 0 || m <= 0) {
            throw new IllegalArgumentException("All inputs must be positive");
        }
    }
    @RequestMapping("/calculate")
    @ResponseBody
    public String calculate(double p, double yr, int m) {
        check(p, yr, m);
        double mr = yr / 12 / 100;
        double pow = Math.pow(1 + mr , m);
        double payment = p * mr * pow / (pow - 1);
        return NumberFormat.getCurrencyInstance().format(payment * m);
    }
}
