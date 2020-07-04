package com.api.dao;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import com.api.entity.ProductEntity;
import com.api.utils.GetJDBCCloudConnection;

public class ProductDao {
  
	private Connection conn;
  
  public ProductDao() {
	  GetJDBCCloudConnection connection = new GetJDBCCloudConnection();
	  conn = connection.getConnection();
	  
  }
 


  public List<ProductEntity> getAllProducts(){
	  ArrayList<ProductEntity> listProducts= new ArrayList<>();
  try {
	conn.setAutoCommit(false);
	
    CallableStatement cs = conn.prepareCall("call admin.get_all_products(?)"); 
    cs.registerOutParameter(1, OracleTypes.CURSOR);

    cs.execute();

    ResultSet rs = (ResultSet) cs.getObject(1);
    while (rs.next()) {

        int codigo = rs.getInt("codigo");
        String descricao = rs.getString("descricao");
        int preco = rs.getInt("preco");
        listProducts.add(new ProductEntity(codigo,descricao,preco));
        
    }
    
    rs.close();
    cs.close();
    return listProducts;
} catch (SQLException e) {
	
	e.printStackTrace();
}
      
      
	  return null;
  }
  
  public ProductEntity getProductByCode(int code){
	  CallableStatement cs;
	try {
		cs = conn.prepareCall("call admin.get_product(?,?)");
		 cs.setInt(1, code);
		    cs.registerOutParameter(2, OracleTypes.CURSOR);

		    cs.execute();

		    ResultSet rs = (ResultSet) cs.getObject(2);
		    
		    int codigo = 0;
		    String descricao = null;
		    int preco = 0;
		    
		    while (rs.next()) {

		        codigo = rs.getInt("codigo");
		        descricao = rs.getString("descricao");
		        preco = rs.getInt("preco");
		        
		    }
		    rs.close();
		    cs.close();
		    return new ProductEntity(codigo,descricao,preco);
	} catch (SQLException e) {
		
		e.printStackTrace();
	} 
   
	return null;
  }
  
  public boolean deleteProducts(int code){
      
    CallableStatement cs;
	try {
		cs = conn.prepareCall("call admin.delete_product(?)");
		cs.setInt("P_CODIGO", code);  
	    cs.execute();
	    cs.close();
	    return true;
	} catch (SQLException e) {
		
		e.printStackTrace();
	}  
    
	  return false;
  }
  
  public boolean updateProduct(int code, String descricao, int preco){
	  try {
		conn.setAutoCommit(false);

	      CallableStatement cs = conn.prepareCall("call admin.update_product(?,?,?)");  
	      
	      cs.setInt("P_CODIGO", code);  
	      cs.setString("P_DESCRICAO", descricao); 
	      cs.setInt("P_PRECO", preco);
	      cs.execute();
	      cs.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
      
      
	  return true;
  }
  
  public boolean createNewProduct(int code, String descricao, int preco) {
	  try {
		conn.setAutoCommit(false);
	    
	    CallableStatement cs = conn.prepareCall("call admin.insert_product(?,?,?)");  
	    
	    cs.setInt("P_CODIGO", code);  
	    cs.setString("P_DESCRICAO", descricao); 
	    cs.setInt("P_PRECO", preco);
	    cs.execute();
	    cs.close();
	} catch (SQLException e) {
		 
		e.printStackTrace();
	}
      
      
    return true;
	 
  }
  
}