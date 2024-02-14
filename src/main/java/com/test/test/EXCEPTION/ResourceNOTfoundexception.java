package com.test.test.EXCEPTION;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
 public class ResourceNOTfoundexception extends  RuntimeException{

     public ResourceNOTfoundexception(String message){
         super(message);
     }
}
