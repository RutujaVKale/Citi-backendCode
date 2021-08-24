package com.Market.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Market.demo.Model.UserLoginDetail;

@Repository
public interface UserAuthenticationRepository extends CrudRepository<com.Market.demo.Model.UserLoginDetail, Integer> {

	com.Market.demo.Model.UserLoginDetail findByUsername(String username);

	//Iterable<UserLoginDetail> findByUsername();
	//public boolean findByUsername(username);

}
