package com.stocks.simple.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.stocks.simple.model.Stock;
import com.stocks.simple.model.Trade;

public class SimpleStockService {
	
	private static SimpleStockService instance;
	private StocksManager stocksManager;

	private SimpleStockService() {
		this.stocksManager = new StocksManager();
		this.stocksManager.setStocks(new HashMap<String,Stock>()); 
		this.stocksManager.setTrades(new HashMap<String,List<Trade>>());  
	}
	
	public static SimpleStockService getInstance() {
		if (SimpleStockService.instance == null)
			SimpleStockService.instance = new SimpleStockService();
		return SimpleStockService.instance;
	}
	
	public void putStock(Stock stock) {
		this.stocksManager.getStocks().put(stock.getSymbol(), stock);
	}
	
	public Stock getStock(String symbol) {
		return this.stocksManager.getStocks().get(symbol);
	}
	
	public void putTrade(Trade trade) {
		if (this.stocksManager.getTrades().containsKey(trade.getStock().getSymbol()))
			this.stocksManager.getTrades().get(trade.getStock().getSymbol()).add(trade);
		else {
			List<Trade> trades = new ArrayList<Trade>();
			trades.add(trade);
			this.stocksManager.getTrades().put(trade.getStock().getSymbol(), trades);
		}
	}
	
	
}
