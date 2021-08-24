package com.Market.demo.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Market.demo.Model.Savestock;
import com.Market.demo.Model.StockDetails;
import com.Market.demo.Model.UserLoginDetail;
import com.Market.demo.Repository.StockRepository;
import com.Market.demo.Repository.UserAuthenticationRepository;

@Service
public class SaveStocksService {

	@Autowired
	StockRepository stockrepo;

	// @Autowired
	Savestock stock1;

	@Autowired
	UserAuthenticationRepository userrepo;

	@Autowired
	NiftyService service;

	// save stock in db
	public void saveStock(Savestock s) {		
		stockrepo.save(s);
	}
	
	//delete stock from db
	public void deleteStock(Savestock s) {		
		stockrepo.deleteStock(s.getUsername(), s.getStockname());
	}

	// get stocks saved by user
	public String[] getStockSaved(String username) {
		List<Savestock> list = stockrepo.findAllByUsername(username);
		
		String[] company = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			
			company[i] = list.get(i).getStockname();
		}
	
		return company;
	}
	
	
	//gets list of names of stocks saved by user in String array and passes it to another function to get deteils of each stock
	public ArrayList<StockDetails> displayStockSavedByUser(String username) throws IOException {
		return service.getStockDetails(getStockSaved(username));
	}

}
