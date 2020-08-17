package com.api.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.api.controllers.ProductController;

import com.api.utils.Handler;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.api.entity.ProductEntity;

public class ProductUpdateByPercentrangeService extends Handler {
	ProductController prodController;

	public ProductUpdateByPercentrangeService(ProductController prodController) {
		super();
		this.prodController = prodController;
	}

	@Override
	protected void execute(HttpExchange exchange) throws IOException {
		exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "http://localhost:8080");

	    if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
	    	exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS, POST, PUT, DELETE");
	    	exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type, Authorization");
	    	exchange.sendResponseHeaders(204, -1);
	            return;
	        }
	    
		

		if ("POST".equals(exchange.getRequestMethod())) {
			try {
				String respText = "REQUEST POST!";			
				int range1= Integer.valueOf(this.getQueryParam(exchange, "rangeUm"));
				int range2= Integer.valueOf(this.getQueryParam(exchange, "rangeDois"));
				int aumentoPercentual = Integer.valueOf(this.getQueryParam(exchange, "aumentoPercentual"));
				boolean responseUpdate = prodController.updateProductByPercentrange(range1,range2, aumentoPercentual);
				exchange.sendResponseHeaders(200, respText.getBytes().length);
				OutputStream output = exchange.getResponseBody();
				output.write(String.valueOf(responseUpdate).getBytes());

				output.flush();
				exchange.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		

		
	}

}