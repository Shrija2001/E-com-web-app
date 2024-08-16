package com.MainApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Pojo.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String>{

	Users findByUnameAndUpass(String uname, String upass);
	
	Users findByUname(String uname);

}
