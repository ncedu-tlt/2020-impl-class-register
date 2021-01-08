package com.pozhenskii.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//string тип данных к которому мы применяем аннотацию
public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> { //проверяет значение
    private String endOfEmail;

    @Override
    public void initialize(CheckEmail constraintAnnotation) {
        endOfEmail = constraintAnnotation.value();
    }

    @Override
    //проверка бизнес правила
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmail); //заканчивается на @gmail.comб, или нет!
    }
}
