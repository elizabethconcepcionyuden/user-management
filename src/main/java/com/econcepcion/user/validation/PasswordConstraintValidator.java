package com.econcepcion.user.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;
@Component
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    private Pattern pattern;

    private final MessageSource messageSource;

    @Value("${pass.regex}")
    private String regex;

    public PasswordConstraintValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.isBlank()) {
            return false;
        }

        boolean matches = pattern.matcher(password).matches();

        if (!matches) {
            context.disableDefaultConstraintViolation();
            String message = messageSource.getMessage("password.invalid", null, LocaleContextHolder.getLocale());
            context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        }

        return matches;
    }
}
