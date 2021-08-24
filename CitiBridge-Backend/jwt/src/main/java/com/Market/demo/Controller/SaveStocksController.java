package com.Market.demo.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Market.demo.Model.Savestock;
import com.Market.demo.Model.StockDetails;
import com.Market.demo.Service.SaveStocksService;

@RestController
@CrossOrigin("*")
public class SaveStocksController {
	
	@Autowired
	SaveStocksService service;

	
	//saves the stock. accepts the object of savestock	
	@PostMapping("/saveStock")
	@CrossOrigin
	@Transactional
	public String saveStock(@RequestBody Savestock s) {
		
		System.out.println("save me");		
		service.saveStock(s);		
		return "saved";		
	}
	
	//deletes the stock 
	@DeleteMapping("/deleteStock")
	@CrossOrigin
	@Transactional
	public String deleteStock(@RequestBody Savestock s) {				
		service.deleteStock(s);		
		return "deleted";		
	}
	
	//displays the socks saved by user in the past
	@GetMapping("/savedstock/{username}")
	@CrossOrigin
	@Transactional
	public ArrayList<StockDetails> getSavedStock(@PathVariable("username") String Username) throws IOException{
		System.out.println("i am called for "+Username);
		return service.displayStockSavedByUser(Username);
	}

}

