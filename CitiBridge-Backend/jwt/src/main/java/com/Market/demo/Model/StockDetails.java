package com.Market.demo.Model;

import java.math.BigDecimal;

public class StockDetails {
	private String CompanyName;
	private String CompanySymbol;
	private BigDecimal Price;
	private BigDecimal OpenPrice;
	private BigDecimal PreviousClosingPrice;
	private BigDecimal MarketCap;
	private long Volume;
	private BigDecimal Dividend;
	
	public StockDetails() {
		
	}
	
	public StockDetails(String companyName, String companySymbol, BigDecimal price, BigDecimal openPrice, BigDecimal previousClosingPrice,
			BigDecimal marketCap, long volume, BigDecimal dividend) {
		super();
		CompanyName = companyName;
		CompanySymbol = companySymbol;
		Price = price;
		OpenPrice = openPrice;
		PreviousClosingPrice = previousClosingPrice;
		MarketCap = marketCap;
		Volume = volume;
		Dividend = dividend;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCompanySymbol() {
		return CompanySymbol;
	}
	public void setCompanySymbol(String companySymbol) {
		CompanySymbol = companySymbol;
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal bigDecimal) {
		Price = bigDecimal;
	}
	public BigDecimal getOpenPrice() {
		return OpenPrice;
	}
	public void setOpenPrice(BigDecimal bigDecimal) {
		OpenPrice = bigDecimal;
	}
	public BigDecimal getPreviousClosingPrice() {
		return PreviousClosingPrice;
	}
	public void setPreviousClosingPrice(BigDecimal bigDecimal) {
		PreviousClosingPrice = bigDecimal;
	}
	public BigDecimal getMarketCap() {
		return MarketCap;
	}
	public void setMarketCap(BigDecimal bigDecimal) {
		MarketCap = bigDecimal;
	}
	public long getVolume() {
		return Volume;
	}
	public void setVolume(long volume) {
		Volume = volume;
	}
	public BigDecimal getDividend() {
		return Dividend;
	}
	public void setDividend(BigDecimal bigDecimal) {
		Dividend = bigDecimal;
	}

	@Override
	public String toString() {
		return "share [CompanyName=" + CompanyName + ", CompanySymbol=" + CompanySymbol + ", Price=" + Price
				+ ", OpenPrice=" + OpenPrice + ", PreviousClosingPrice=" + PreviousClosingPrice + ", MarketCap="
				+ MarketCap + ", Volume=" + Volume + ", Dividend=" + Dividend + "]";
	}
	

}
