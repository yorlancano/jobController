package com.employee_Management.employment.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException {
    private static final long serialVersionId = 1L;

    public ResourceNotFoundExeption(String messenger){
        super(messenger);
    }
}
