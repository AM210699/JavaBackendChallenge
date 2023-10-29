package com.example.javabackendchallengepostwork.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PhoneValidator {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\d{2,4}[- .]?){2}\\d{4}$");


    public boolean isValid(String telephone) {
        return PHONE_PATTERN.matcher(telephone).matches();
    }

    public String cleanNumber(String telephone){
        return telephone.replaceAll("[^0-9]", "");

    }

}
