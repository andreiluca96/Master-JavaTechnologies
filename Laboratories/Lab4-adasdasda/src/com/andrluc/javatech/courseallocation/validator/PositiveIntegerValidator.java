package com.andrluc.javatech.courseallocation.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="PositiveIntegerValidator")
public class PositiveIntegerValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        int integer = (Integer) o;

        if (integer < 0) {
            throw new RuntimeException("The " + integer + " must be positive.");
        }
    }
}
