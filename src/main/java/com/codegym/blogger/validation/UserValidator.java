package com.codegym.blogger.validation;

import com.codegym.blogger.model.UserForm;
import com.codegym.blogger.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    private UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserForm user = (UserForm) target;
        String email = user.getEmail();
        String password = user.getPassword();
        int age = user.getAge();
        String rePassword = user.getRePassword();


        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
        ValidationUtils.rejectIfEmpty(errors, "rePassword", "rePassword.empty");
        ValidationUtils.rejectIfEmpty(errors, "avatar", "avatar.empty");

        if (userService.existEmail(email)) {
            errors.rejectValue("email", "email.exists");
        }
        if (password!=null && rePassword!= null && password != rePassword) {
            errors.rejectValue("rePassword", "rePassword.matches");
        }

        if (age <= 0) {
            errors.rejectValue("age", "age.matches");
        }

        if (password != null && password.length() < 6 || password.length() > 20) {
            errors.rejectValue("password", "password.length");
        }
    }
}
