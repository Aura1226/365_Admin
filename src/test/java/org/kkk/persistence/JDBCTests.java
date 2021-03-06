package org.kkk.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}//try
	}//static
	
	@Test
	public void testConnection() {
		
		try (Connection con = 
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
										"dclub",
										"dclub")){
											log.info(con);					
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}//try
		
	}//testConnection
	
}
