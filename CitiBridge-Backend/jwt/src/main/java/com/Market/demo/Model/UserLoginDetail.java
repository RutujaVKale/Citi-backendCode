package com.Market.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userlogindetail")
public class UserLoginDetail {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	private String username;
	private String password;
	
	public UserLoginDetail() {
		
	}

	public UserLoginDetail(int userid, String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}

	public int getUserId() {
		return userid;
	}

	public void setUserId(int userId) {
		this.userid = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
