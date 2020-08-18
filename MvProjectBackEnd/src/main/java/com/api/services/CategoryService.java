package com.api.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.api.controllers.ProductController;

import com.api.utils.Handler;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.api.entity.CategoryEntity;
import com.api.entity.ProductEntity;

public class CategoryService extends Handler {
	ProductController prodController;

	public CategoryService(ProductController prodController) {
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
	    
		if ("GET".equals(exchange.getRequestMethod())) {
			try {
				List<CategoryEntity> categories = prodController.getAllCategories();
				String respText = new Gson().toJson(categories);
				exchange.sendResponseHeaders(200, respText.getBytes().length);
				OutputStream output = exchange.getResponseBody();
				output.write(respText.getBytes());
				output.flush();
				exchange.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		

		

		
	}

}