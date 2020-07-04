package com.api.utils;


import java.util.HashMap;
import java.util.Map;

import com.api.errors.GlobalExceptionHandler;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;


import io.vavr.control.Try;

public abstract class Handler {

   
    private final GlobalExceptionHandler exceptionHandler;
    
    public Handler() {
       
        this.exceptionHandler = new GlobalExceptionHandler();
        
    }

    public void handle(HttpExchange exchange) {
        Try.run(() -> execute(exchange))
            .onFailure(thr -> exceptionHandler.handle(thr, exchange));
    }

    protected abstract void execute(HttpExchange exchange) throws Exception;


    
    protected static Headers getHeaders(String key, String value) {
        Headers headers = new Headers();
        headers.set(key, value);
        return headers;
    }
    public String getQueryParam(HttpExchange exchange, String param){
    	Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
    	return params.get(param);
    }
    
    public Map<String, String> queryToMap(String query) {
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            }else{
                result.put(entry[0], "");
            }
        }
        return result;
    }
}

