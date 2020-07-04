package com.api.errors;

import java.io.IOException;

import java.io.OutputStream;

import com.api.constants.Constants;
import com.api.errors.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

public class GlobalExceptionHandler {
    

    public void handle(Throwable throwable, HttpExchange exchange) {
        try {
            throwable.printStackTrace();
            exchange.getResponseHeaders().set(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);
            Boolean errors = getErrorResponse(throwable, exchange);
            OutputStream responseBody = exchange.getResponseBody();
            
            responseBody.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean getErrorResponse(Throwable throwable, HttpExchange exchange) throws IOException {
        
        if (throwable instanceof InvalidRequestException) {
            InvalidRequestException exc = (InvalidRequestException) throwable;
           
            exchange.sendResponseHeaders(400, 0);
        } else if (throwable instanceof ResourceNotFoundException) {
            ResourceNotFoundException exc = (ResourceNotFoundException) throwable;
           
            exchange.sendResponseHeaders(404, 0);
        } else if (throwable instanceof MethodNotAllowedException) {
            MethodNotAllowedException exc = (MethodNotAllowedException) throwable;
            
            exchange.sendResponseHeaders(405, 0);
        } else {
            
            exchange.sendResponseHeaders(500, 0);
        }
        return true;
    }
}
