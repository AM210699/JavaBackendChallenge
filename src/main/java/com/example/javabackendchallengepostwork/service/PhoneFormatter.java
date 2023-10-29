package com.example.javabackendchallengepostwork.service;


import org.springframework.stereotype.Service;

@Service
public class PhoneFormatter {

    private static final String INITIAL_TELEPHONE_FORMAT = "(\\d{2})(\\d{4})(\\d+)";
    private static final String FINAL_TELEPHONE_FORMAT = "($1)-$2-$3";

    public String format(String telephone) {
        return String.valueOf(telephone).replaceFirst(INITIAL_TELEPHONE_FORMAT, FINAL_TELEPHONE_FORMAT);

    }

}