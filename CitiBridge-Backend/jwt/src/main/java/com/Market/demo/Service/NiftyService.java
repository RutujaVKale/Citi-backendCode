package com.Market.demo.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Market.demo.Model.StockDetails;
import com.Market.demo.Model.UserLoginDetail;
import com.Market.demo.Repository.UserAuthenticationRepository;


import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@Service
public class NiftyService {
	@Autowired
	UserAuthenticationRepository repo;

	// Object of stock details class
	StockDetails share;

	// This is an array of large cap nifty 50 stocks
	public static String[] niftyLargeCapCompanies = { "ADANIPORTS.NS", "ASIANPAINT.NS", "AXISBANK.NS", "BAJAJ-AUTO.NS",
			"BAJFINANCE.NS", "BAJAJFINSV.NS", "BPCL.NS", "BHARTIARTL.NS", "HDFCLIFE.NS", "BRITANNIA.NS", "CIPLA.NS",
			"COALINDIA.NS", "DRREDDY.NS", "EICHERMOT.NS", "GAIL.NS", "GRASIM.NS", "HCLTECH.NS", "HDFCBANK.NS",
			"HEROMOTOCO.NS", "HINDALCO.NS", "HINDUNILVR.NS", "HDFC.NS", "ICICIBANK.NS", "ITC.NS", "IOC.NS",
			"INDUSINDBK.NS", "INFY.NS", "JSWSTEEL.NS", "KOTAKBANK.NS", "LT.NS", "M&M.NS", "MARUTI.NS", "NTPC.NS",
			"NESTLEIND.NS", "ONGC.NS", "POWERGRID.NS", "RELIANCE.NS", "SHREECEM.NS", "SBIN.NS", "SUNPHARMA.NS",
			"TCS.NS", "TATAMOTORS.NS", "TATASTEEL.NS", "TECHM.NS", "TITAN.NS", "UPL.NS", "ULTRACEMCO.NS", "VEDL.NS",
			"WIPRO.NS", "DIVISLAB.NS" };

	public static String[] niftyMidCapCompanies = { "AUBANK.NS", "AMARAJABAT.NS", "APOLLOTYRE.NS", "ASHOKLEY.NS",
			"BALKRISIND.NS", "BANKBARODA.NS", "BANKINDIA.NS", "BATAINDIA.NS", "BEL.NS", "BHARATFORG.NS", "BHEL.NS",
			"CANBK.NS", "CASTROLIND.NS", "CHOLAFIN.NS", "COFORGE.NS", "CONCOR.NS", "CUMMINSIND.NS", "ESCORTS.NS",
			"EXIDEIND.NS", "FEDERALBNK.NS", "GMRINFRA.NS", "GLENMARK.NS", "GODREJPROP.NS", "IDFCFIRSTB.NS",
			"IBULHSGFIN.NS", "IRCTC.NS", "L&TFH.NS", "LICHSGFIN.NS", "MGL.NS", "M&MFIN.NS",
			"MANAPPURAM.NS", "MFSL.NS", "MINDTREE.NS", "PAGEIND.NS", "PFC.NS", "RBLBANK.NS", "RECLTD.NS", "SRF.NS",
			"SRTRANSFIN.NS", "SAIL.NS", "SUNTV.NS", "TVSMOTOR.NS", "TATAPOWER.NS", "RAMCOCEM.NS", "TORNTPOWER.NS",
			"UNIONBANK.NS", "IDEA.NS", "VOLTAS.NS", "ZEEL.NS" };

	public static String[] niftySmallCapCompanies = { "APLAPOLLO.NS", "AARTIDRUGS.NS", "AFFLE.NS", "ALKYLAMINE.NS",
			"ALOKINDS.NS", "AMBER.NS", "AVANTIFEED.NS", "BAJAJELEC.NS", "BDL.NS", "BIRLACORPN.NS", "BSOFT.NS",
			"CANFINHOME.NS", "CEATLTD.NS", "CDSL.NS", "CHAMBLFERT.NS", "COCHINSHIP.NS", "CAMS.NS", "CYIENT.NS",
			"DBL.NS", "FSL.NS", "FRETAIL.NS", "GMMPFAUDLR.NS", "GRANULES.NS", "GRAPHITE.NS", "HAPPSTMNDS.NS", "IDFC.NS",
			"INDIANB.NS", "JBCHEPHARM.NS", "KAJARIACER.NS", "KEC.NS", "MCX.NS", "NBCC.NS", "NATIONALUM.NS",
			"PNBHOUSING.NS", "PVR.NS", "RITES.NS", "RADICO.NS", "RVNL.NS", "RALLIS.NS", "ROUTE.NS", "STLTECH.NS",
			"STAR.NS", "SPARC.NS", "SUNTECK.NS", "TV18BRDCST.NS", "THYROCARE.NS", "UTIAMC.NS", "VIPIND.NS",
			"VAKRANGEE.NS", "WOCKPHARMA.NS" };

	// This method return list of stock details
	public ArrayList<StockDetails> getStockDetails(String[] companies) throws IOException {
		Map<String, Stock> stocks = YahooFinance.get(companies);
		ArrayList<StockDetails> list = new ArrayList<>();
		share = new StockDetails();
		for (Map.Entry<String, Stock> entry : stocks.entrySet()) {
			share = new StockDetails();
			share.setCompanyName(entry.getValue().getName());
			share.setCompanySymbol(entry.getValue().getQuote().getSymbol());
			share.setPrice(entry.getValue().getQuote().getPrice());
			share.setMarketCap(entry.getValue().getStats().getMarketCap());
			share.setOpenPrice(entry.getValue().getQuote().getOpen());
			share.setPreviousClosingPrice(entry.getValue().getQuote().getPreviousClose());
			share.setVolume(entry.getValue().getQuote().getVolume());
			share.setDividend(entry.getValue().getDividend().getAnnualYield());
			list.add(share);
		}
		return list;
	}

	// this method returns list of all stocks based on argument . The list if of
	// type share object
	public ArrayList<StockDetails> getAllStocksDetails(String marketCap) throws IOException {
		if (marketCap.equals("largeCap")) {
			return getStockDetails(niftyLargeCapCompanies);

		} else if (marketCap.equals("midCap")) {
			return getStockDetails(niftyMidCapCompanies);

		} else if (marketCap.equals("smallCap")) {
			return getStockDetails(niftySmallCapCompanies);

		}
		return null;

	}

	// this method will return top performing stocks
	public String convertDate(Calendar cal) {
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = fomat.format(cal.getTime());
		return formatDate;
	}

	StockDetails stock;

	public String[] getTopStocks(int day, String niftyCompanies[]) throws IOException {
		Calendar from = Calendar.getInstance();// from the day back
		Calendar to = Calendar.getInstance(); // todays date
		from.add(Calendar.DAY_OF_MONTH, Integer.valueOf("-" + day));

		HashMap<String, BigDecimal> h = new HashMap<String, BigDecimal>();

		try {
			for (int i = 0; i < niftyCompanies.length; i++) {
				Stock stockname1 = YahooFinance.get(niftyCompanies[i]);
				List<HistoricalQuote> history1 = stockname1.getHistory(from, to, Interval.DAILY);

				if (history1 != null) {

					BigDecimal opening = history1.get(0).getOpen();// opening price 14th day back
					BigDecimal closing = history1.get((history1.size() - 1)).getClose(); // closing price of tdy
					BigDecimal dividend = stockname1.getDividend().getAnnualYield();
					BigDecimal TotalStockReturn = null;

					if (!opening.equals(null)) {
//						TotalStockReturn = (((closing.subtract(opening)).add(dividend)).divide(opening, 3, RoundingMode.CEILING));
						TotalStockReturn = (((closing.subtract(opening))).divide(opening, 3, RoundingMode.CEILING));


					}

					h.put(niftyCompanies[i], TotalStockReturn);
				}
			}

		} catch (ArithmeticException e) {
			System.out.println("divide by zero!!!!");
		}
//					
		// conert hashmap to list
		List<Entry<String, BigDecimal>> list = new LinkedList<Entry<String, BigDecimal>>(h.entrySet());
		Collections.sort(list, new Comparator<Entry<String, BigDecimal>>() {

			@Override
			public int compare(Entry<String, BigDecimal> o1, Entry<String, BigDecimal> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}

		});

		HashMap<String, BigDecimal> t = new LinkedHashMap<String, BigDecimal>();
		for (Map.Entry<String, BigDecimal> aa : list) {
			t.put(aa.getKey(), aa.getValue());
		}

		for (Entry<String, BigDecimal> entry : t.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		String comp[] = new String[t.size()];
		int count=5, m =0;
		Iterator<Entry<String, BigDecimal>> it = t.entrySet().iterator();
		while(it.hasNext()) {
			//Map.Entry<String, BigDecimal> set = (Map.Entry<String, BigDecimal>)it.next();
			Entry<String, BigDecimal> set = it.next();
			comp[m]=set.getKey();
			System.out.println(set.getKey());
			m++;
			
		}
		
		System.out.println("____________________________________________");
		for(int i=0;i<comp.length;i++) {
			System.out.println(comp[i]);
		}
		System.out.println("____________________________________________");
		String Top[]=new String[5];
		for(int i=0;i<5;i++) {
			Top[i]=comp[i];
		}
		
		System.out.println("_**********************************************");
		for(int i=0;i<5;i++) {
			System.out.println(Top[i]);
		}
		System.out.println("_**********************************************");

		return Top;

	}

	// calling history details for all nifty stocks
	public ArrayList<StockDetails> getTopNiftyStocks(String marketCap) throws IOException {					
		
		if (marketCap.equals("largeCap")) {
			String ans[]= getTopStocks(14,niftyLargeCapCompanies);
			return getStockDetails(ans);

		} else if (marketCap.equals("midCap")) {
			String ans[]= getTopStocks(14,niftyMidCapCompanies);
			return getStockDetails(ans);

		} else if (marketCap.equals("smallCap")) {
			String ans[]= getTopStocks(14,niftySmallCapCompanies);
			return getStockDetails(ans);

		}
		return null;
		
	}

}
