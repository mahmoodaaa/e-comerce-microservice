package com.e_cmmerce.Order_Service.error;

import org.springframework.http.HttpStatus;

public class RecordNotFoundExciption extends ApiBaseException {


    public RecordNotFoundExciption(String message) {
        super(message);
    }

    public HttpStatus getStatusCode(){

       return  HttpStatus.NOT_FOUND;

    }


}
