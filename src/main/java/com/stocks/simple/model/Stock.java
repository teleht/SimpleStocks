package com.stocks.simple.model;

public class Stock {
	
	private StockType type;
	private String symbol;
	private double lastDividend;
	private double fixedDividend;
	private double parValue;
	private double tickerPrice;
	
	public StockType getType() {
		return type;
	}
	public void setType(StockType type) {
		this.type = type;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public double getParValue() {
		return parValue;
	}
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}
	public double getTickerPrice() {
		return tickerPrice;
	}
	public void setTickerPrice(double tickerPrice) {
		this.tickerPrice = tickerPrice;
	}
	
}
