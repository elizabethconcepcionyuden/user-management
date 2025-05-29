package com.econcepcion.user.validation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordPolicyConfig implements PasswordPolicyProvider {

    private final String pattern;

    public PasswordPolicyConfig(@Value("${pass.regex}") String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return pattern;
    }
}
