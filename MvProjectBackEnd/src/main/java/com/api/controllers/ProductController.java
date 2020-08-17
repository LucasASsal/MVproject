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
	
	public boolean updateProduct(int codigo, int categoria, String descricao, int preco) {
		return productDao.updateProduct(codigo,categoria, descricao, preco);
	}
	
	public boolean deleteProduct(int code) {
		return productDao.deleteProducts(code);
	}
	
	public boolean createProduct(int code, int categoria, String description, int price) {
		return productDao.createNewProduct(code,categoria, description, price);
	}

	public boolean updateProductByCategory(int categoria, int aumentoPercentual) {
		return productDao.updateProductByCategory(categoria, aumentoPercentual);
	}

	public boolean updateProductByPercentrange(int range1, int range2, int aumentoPercentual) {
		return productDao.updateProductByPercentrange(range1,range2, aumentoPercentual);
	}

}
