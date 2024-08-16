package com.MainApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Pojo.Admin;

@Repository
public interface AdminRepository extends  CrudRepository<Admin, String>{

	Admin findByUnameAndUpass(String uname, String upass);

	Admin findByUname(String uname);
	
}
