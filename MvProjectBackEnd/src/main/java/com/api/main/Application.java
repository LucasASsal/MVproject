package com.api.main;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.api.controllers.ProductController;
import com.api.services.ProductService;
import com.api.services.ProductUpdateByCategoryService;
import com.api.services.ProductUpdateByPercentrangeService;
import com.sun.net.httpserver.HttpServer;
import com.api.services.CategoryService;

class Application {

	public static void main(String[] args){
        int serverPort = 5000;
        HttpServer server = null;
		try {
			server = HttpServer.create(new InetSocketAddress(serverPort), 0);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		ProductController prodController = new ProductController();;
        ProductService productService = new ProductService(prodController);
        ProductUpdateByCategoryService productUpdateByCategoryService = new ProductUpdateByCategoryService(prodController);
        ProductUpdateByPercentrangeService productUpdateByPercentrangeService = new ProductUpdateByPercentrangeService(prodController);
        CategoryService categoryService = new CategoryService(prodController);
        server.createContext("/api/produto", productService::handle);
        server.createContext("/api/atualizaproduto/porcategoria", productUpdateByCategoryService::handle);
        server.createContext("/api/atualizaproduto/porfaixadeporcentagem", productUpdateByPercentrangeService::handle);
        server.createContext("/api/categorias", categoryService::handle);
        System.out.println("Server running...at port: "+serverPort );
        server.setExecutor(null); 
        server.start();
    }
}

