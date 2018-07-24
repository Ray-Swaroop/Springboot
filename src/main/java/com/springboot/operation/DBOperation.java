package com.springboot.operation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;

import com.springboot.db.ConnectionToDb;
import com.springboot.model.Order;
import com.springboot.model.Product;
import com.springboot.model.User;

@ComponentScan
public class DBOperation {

	public static Map<Integer, String> getAll() throws SQLException{
		Connection conn= ConnectionToDb.connect();
		Statement stmt = conn.createStatement();
		Map<Integer,String> map=new HashMap<Integer,String>();
		try{
			ResultSet rs = stmt.executeQuery( "SELECT * FROM User;" );
			while ( rs.next() ) {
				int id = rs.getInt("UserId");
				String name=rs.getString("UserName");
				map.put(id, name);
			}	
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			conn.close();
		}
		return map;		
	}

	public static int createUser(User user) throws SQLException{
		Connection conn= ConnectionToDb.connect();
		Statement stmt = conn.createStatement();
		int result=0;
		try{
			String query=String.format("insert into User(UserId,UserName)values(%s,\"%s\")",user.getUserId(),user.getUserName());
			result=stmt.executeUpdate(query);
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			conn.close();
		}
		return result;
	}
	
	public static int createProduct(Product product) throws SQLException{
		Connection conn= ConnectionToDb.connect();
		Statement stmt = conn.createStatement();
		int result=0;
		try{
			String query=String.format("insert into Product(ProductId,ProductName,Price)values(%s,\"%s\",\"%s\")",product.getProductId(),product.getProductName(),product.getProductPrice());
			result=stmt.executeUpdate(query);
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			conn.close();
		}
		return result;
	}
	
	public static int createOrder(Order order) throws SQLException{
		Connection conn= ConnectionToDb.connect();
		Statement stmt = conn.createStatement();
		int result=0;
		try{
			String query=String.format("insert into OrderItem(OrderId,OrderStatus)values(%s,\"%s\")",order.getOrderId(),order.getOrderStatus());
			result=stmt.executeUpdate(query);
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			conn.close();
		}
		return result;
	}

	public static int changeOrderStatus(Order status) throws SQLException {
		Connection conn= ConnectionToDb.connect();
		Statement stmt = conn.createStatement();
		int result=0;
		try{
			String query=String.format("UPDATE OrderItem set OrderStatus = \"%s\" where OrderId=%s",status.getOrderStatus(),status.getOrderId());
			result=stmt.executeUpdate(query);
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			conn.close();
		}
		return result;
	}

}
