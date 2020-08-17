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

public class ProductService extends Handler {
	ProductController prodController;

	public ProductService(ProductController prodController) {
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
				List<ProductEntity> products = prodController.getAllProducts();
				String respText = new Gson().toJson(products);
				exchange.sendResponseHeaders(200, respText.getBytes().length);
				OutputStream output = exchange.getResponseBody();
				output.write(respText.getBytes());
				output.flush();
				exchange.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		if ("POST".equals(exchange.getRequestMethod())) {
			try {
				String respText = "REQUEST POST!";
				InputStream is = exchange.getRequestBody();
				String descricao = new String(is.readAllBytes());
				int codigo = Integer.valueOf(this.getQueryParam(exchange, "codigo"));
				int categoria= Integer.valueOf(this.getQueryParam(exchange, "categoria"));
				int preco = Integer.valueOf(this.getQueryParam(exchange, "preco"));
				boolean responseUpdate = prodController.updateProduct(codigo, categoria, descricao, preco);
				exchange.sendResponseHeaders(200, respText.getBytes().length);
				OutputStream output = exchange.getResponseBody();
				output.write(String.valueOf(responseUpdate).getBytes());

				output.flush();
				exchange.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if ("DELETE".equals(exchange.getRequestMethod())) {
			try {
				String respText = "REQUEST DELETE!";

				exchange.sendResponseHeaders(200, respText.getBytes().length);
				int codigo = Integer.valueOf(this.getQueryParam(exchange, "codigo"));
				boolean responseDelete = prodController.deleteProduct(codigo);
				OutputStream output = exchange.getResponseBody();
				output.write(String.valueOf(responseDelete).getBytes());
				output.flush();
				exchange.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if ("PUT".equals(exchange.getRequestMethod())) {
			try {
				String respText = "REQUEST PUT!";
				InputStream is = exchange.getRequestBody();
				String descricao = new String(is.readAllBytes());
				int codigo = Integer.valueOf(this.getQueryParam(exchange, "codigo"));
				int categoria= Integer.valueOf(this.getQueryParam(exchange, "categoria"));
				int preco = Integer.valueOf(this.getQueryParam(exchange, "preco"));
				boolean responseCreate = prodController.createProduct(codigo,categoria, descricao, preco);
				exchange.sendResponseHeaders(200, respText.getBytes().length);
				OutputStream output = exchange.getResponseBody();
				output.write(String.valueOf(responseCreate).getBytes());
				output.flush();
				exchange.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}