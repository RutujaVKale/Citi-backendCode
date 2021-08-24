package com.Market.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="savestock")
public class Savestock {
	
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String username;
	private String stockname;
	
	public Savestock() {}

	public Savestock(int id, String username, String stockname) {
		super();
		this.id = id;
		this.username = username;
		this.stockname = stockname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStockname() {
		return stockname;
	}

	public void setStockname(String stockname) {
		this.stockname = stockname;
	}

	@Override
	public String toString() {
		return "Savestock [id=" + id + ", username=" + username + ", stockname=" + stockname + "]";
	}

	
	
	
	
	
	

}
