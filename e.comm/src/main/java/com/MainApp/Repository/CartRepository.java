package com.MainApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Pojo.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer>{


	List<Cart> findByUname(String uname);
	
}
