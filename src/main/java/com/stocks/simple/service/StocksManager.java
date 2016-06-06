package com.stocks.simple.service;

import java.util.List;
import java.util.Map;

import com.stocks.simple.model.Stock;
import com.stocks.simple.model.Trade;

public class StocksManager {

	private Map<String, Stock> stocks;
	private Map<String, List<Trade>> trades;
	
	public Map<String, Stock> getStocks() {
		return stocks;
	}
	public void setStocks(Map<String, Stock> stocks) {
		this.stocks = stocks;
	}
	public Map<String, List<Trade>> getTrades() {
		return trades;
	}
	public void setTrades(Map<String, List<Trade>> trades) {
		this.trades = trades;
	}
	
	
}
