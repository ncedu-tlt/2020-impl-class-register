package com.pozhenskii.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler //проверка, выбросился ли эксэпшен EmployeeIncorrencData
    public ResponseEntity<EmployeeIncorrencData> handleException(
            NoSuchEmployeeException exception) {
        EmployeeIncorrencData data = new EmployeeIncorrencData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND); // Возвращаем http ответ как ненайденный
    }

    @ExceptionHandler //проверка, выбросился ли какой либо эксэпшен
    public ResponseEntity<EmployeeIncorrencData> handleException(
            Exception exception) {
        EmployeeIncorrencData data = new EmployeeIncorrencData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST); // Как неправильный запрос
    }
}
