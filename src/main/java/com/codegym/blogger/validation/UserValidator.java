package com.codegym.blogger.validation;

import com.codegym.blogger.model.UserForm;
import com.codegym.blogger.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

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
        String name = user.getName();
        String password = user.getPassword();

        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");

        if(userService.existEmail(email)) {
            errors.rejectValue("email", "email.exists" );
        }
//        if (userService.existPhone(phone)) {
//            errors.rejectValue("phone", "phone.exists");
//        }
        if (password.length() < 6 || password.length() >20){
            errors.rejectValue("password", "password.length");
        }
    }
}
