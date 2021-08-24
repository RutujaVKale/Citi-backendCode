package com.Market.demo.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Market.demo.Model.UserLoginDetail;
import com.Market.demo.Repository.UserAuthenticationRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
		
		@Autowired
		private UserAuthenticationRepository repository;
		
		//check if user is registered user 
		@Override
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			UserLoginDetail user = repository.findByUsername(userName);
			
			if(user!=null) {
				return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
			}else {
				throw new UsernameNotFoundException("User not found!!");
			}
		}
	}


