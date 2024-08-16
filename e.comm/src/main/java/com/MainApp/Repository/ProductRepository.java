package com.MainApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Pojo.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String>{

	List<Product> findByUname(String uname);
	
	void deleteByPname(String pname);
	
	List<Product> findAll();

	Product findByUnameAndPname(String adname, String pname);

	
	
	
}
