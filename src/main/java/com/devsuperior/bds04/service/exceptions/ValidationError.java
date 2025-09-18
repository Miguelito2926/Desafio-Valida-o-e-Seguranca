package com.devsuperior.bds04.service.exceptions;

import com.devsuperior.bds04.controller.exceptions.FieldMessage;
import com.devsuperior.bds04.controller.exceptions.StandardError;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private final List<FieldMessage> errors = new ArrayList<>();

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
