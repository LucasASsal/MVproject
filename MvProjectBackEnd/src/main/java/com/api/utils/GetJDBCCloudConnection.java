package com.api.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class GetJDBCCloudConnection {
	  private static String DB_URL;
	  final static String DB_USER = "admin";
	  final static String DB_PASSWORD = "Abcdefgh123456";
	  final static String CONN_FACTORY_CLASS_NAME="oracle.jdbc.pool.OracleDataSource";
	  
	public Connection getConnection() {
		String basePath = new File("").getAbsolutePath();

	    String pathToKey = new File("src/databaseKey").getAbsolutePath();
	    DB_URL= "jdbc:oracle:thin:@dbmvproject_medium?TNS_ADMIN="+pathToKey;
		PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
		  Connection conn = null;
		try {
			  System.out.println("trying to connect... "); 
			  pds.setConnectionFactoryClassName(CONN_FACTORY_CLASS_NAME);
			  pds.setURL(DB_URL);
			  pds.setUser(DB_USER);
			  pds.setPassword(DB_PASSWORD);
			  pds.setConnectionPoolName("JDBC_UCP_POOL");
			  pds.setInitialPoolSize(5);
			  pds.setMinPoolSize(5);
			  pds.setMaxPoolSize(20);
			  pds.setTimeoutCheckInterval(5);
			  pds.setInactiveConnectionTimeout(10);
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  try {
			  conn= pds.getConnection();
		      System.out.println("Available connections after checkout: "
		          + pds.getAvailableConnectionsCount());
		      System.out.println("Borrowed connections after checkout: "
		          + pds.getBorrowedConnectionsCount());
		     
		      
		    }
		    catch (SQLException e) {
		      System.out.println("UCPSample - " + "SQLException occurred : "
		          + e.getMessage());
		    }
		    try {
				System.out.println("Available connections after checkin: "
				    + pds.getAvailableConnectionsCount());
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		    try {
				System.out.println("Borrowed connections after checkin: "
				    + pds.getBorrowedConnectionsCount());
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		    return conn;
		
	}

}
