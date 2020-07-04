package com.api.controllers;
import java.util.List;

import com.api.entity.ProductEntity;
import com.api.dao.ProductDao;
public class ProductController {
	ProductDao productDao = new ProductDao();
	public ProductEntity getProduct(int code) {
		return productDao.getProductByCode(code);
	}
	
	public List<ProductEntity> getAllProducts(){
		return productDao.getAllProducts();
	}
	
	public boolean updateProduct(int codigo, String descricao, int preco) {
		return productDao.updateProduct(codigo, descricao, preco);
	}
	
	public boolean deleteProduct(int code) {
		return productDao.deleteProducts(code);
	}
	
	public boolean createProduct(int code, String description, int price) {
		return productDao.createNewProduct(code, description, price);
	}

}
