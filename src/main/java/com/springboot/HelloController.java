package com.springboot;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Order;
import com.springboot.model.Product;
import com.springboot.model.User;
import com.springboot.operation.DBOperation;

@RestController
public class HelloController {
	
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public Map<Integer,String> get() throws SQLException{
        Map<Integer,String> details=DBOperation.getAll();
    	return details;
    }
    
    @RequestMapping(value = "/postData/user", method = RequestMethod.POST)
    public ResponseEntity <String> postUser(@RequestBody User user) throws SQLException{	
    	int result;   	
    	result=DBOperation.createUser(user);
    	if(result==0){
    		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    	}
    	else{
    		return ResponseEntity.status(HttpStatus.CREATED).build();
    	}
    }
    
    @RequestMapping(value = "/postData/product", method = RequestMethod.POST)
    public ResponseEntity <String> postProduct(@RequestBody Product product) throws SQLException{
    	int result;   	
    	result=DBOperation.createProduct(product);
    	if(result==0){
    		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    	}
    	else{
    		return ResponseEntity.status(HttpStatus.CREATED).build();
    	}
    }
    
    @RequestMapping(value = "/postData/order", method = RequestMethod.POST)
    public ResponseEntity <String> postOrder(@RequestBody Order order) throws SQLException{
    	int result;   	
    	result=DBOperation.createOrder(order);
    	if(result==0){
    		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    	}
    	else{
    		return ResponseEntity.status(HttpStatus.CREATED).build();
    	}
    }
    
    @RequestMapping(value = "/changeOrder/status", method = RequestMethod.PUT)
    public ResponseEntity <String> orderStatus(@RequestBody Order status) throws SQLException{
    	int result;   	
    	result=DBOperation.changeOrderStatus(status);
    	if(result==0){
    		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    	}
    	else{
    		return ResponseEntity.status(HttpStatus.CREATED).build();
    	}
    }
}
