package com.registration.web.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ValidationErrorDTO {
	private final List<FieldErrorDTO> fieldErrors = new ArrayList<FieldErrorDTO>();

    public ValidationErrorDTO() {
        super();
    }

    //

    public final void addFieldError(final String path, final String message) {
        final FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }

    public final List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }

    //

    @Override
    public final String toString() {
        final StringBuilder builder = new StringBuilder();
        List<FieldErrorDTO> errors = getFieldErrors();
        boolean firstOne = true;
		for (Iterator iterator = errors.iterator(); iterator.hasNext();) {
			FieldErrorDTO fieldErrorDTO = (FieldErrorDTO) iterator.next();
			if(firstOne) {
				builder.append(fieldErrorDTO.getMessage());
			}else {
				builder.append("\n").append(fieldErrorDTO.getMessage());
			}
		}
        return builder.toString();
    }

}
