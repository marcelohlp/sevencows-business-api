package com.sevencows.business.util;

public class RegexConstant {

    public static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,20}$";

    private RegexConstant() {
    }

}
