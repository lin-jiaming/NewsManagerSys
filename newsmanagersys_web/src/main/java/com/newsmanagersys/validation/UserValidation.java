package com.newsmanagersys.validation;

import com.newsmanagersys.entity.Users;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
