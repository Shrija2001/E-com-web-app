package com.MainApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Pojo.BuyProduct;

@Repository
public interface BuyProductRepository extends CrudRepository<BuyProduct, Integer>{

	List<BuyProduct> findByUname(String uname);
	List<BuyProduct> findByAdname(String adname);
	
}
