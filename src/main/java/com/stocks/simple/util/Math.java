package com.stocks.simple.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.StatUtils;

import com.stocks.simple.model.Stock;
import com.stocks.simple.model.StockType;
import com.stocks.simple.model.Trade;

public class Math {

	public static double calculateDividendYield(Stock stock) throws Exception {
		
		double dividendYield = -1;
		
		if (stock.getLastDividend() == 0)
			throw new Exception("The ticker price for the stock ["+stock.getSymbol()+"] should be greater than zero (0).");
		
		if (stock.getType() == StockType.COMMON) {
			if (stock.getLastDividend() == 0)
				throw new Exception("The last dividend for the stock ["+stock.getSymbol()+"] should be greater than zero (0).");
			dividendYield = stock.getLastDividend() / stock.getTickerPrice();
		}
		else {
			if (stock.getFixedDividend() == 0)
				throw new Exception("The fixed dividend for the stock ["+stock.getSymbol()+"] should be greater than zero (0).");
			if (stock.getParValue() == 0)
				throw new Exception("The par value for the stock ["+stock.getSymbol()+"] should be greater than zero (0).");
			dividendYield = (stock.getFixedDividend() * stock.getParValue()) / stock.getTickerPrice();
		}
		
		return dividendYield;
	}
	
	public static double calculatePERatio(Stock stock) throws Exception {
		
		double peRatio = -1;
		double dividend = calculateDividendYield(stock);
		
		if (dividend > 0)
			peRatio = stock.getTickerPrice() / dividend;
		
		return peRatio;
	}
	
	public static double calculateStockPriceInRange(List<Trade> trades) {
		
		double priceQuentity = 0;
		double quantity = 0;
		
		for (Trade trade : trades) {
			priceQuentity = priceQuentity + (trade.getPrice() * (double) trade.getQuantity());
			quantity =  quantity + (double) trade.getQuantity();
		}
		
		if (priceQuentity == 0 || quantity == 0)
			return 0;
		
		return priceQuentity/quantity;
	}
	
	public static double calculateStockPrice(Trade trade) {
		
		if (trade.getQuantity() == 0 || trade.getPrice() == 0)
			return 0;
		
		return (trade.getPrice() * (double) trade.getQuantity())/(double) trade.getQuantity();
	}
	
	public static double calculateGBCEAllShareIndex(List<Trade> stockTrades) throws Exception {
		
		double gbce = 0;
		
		List<Double> stockPrices = new ArrayList<Double>();
		for(Trade trade: stockTrades){
			double stockPrice = calculateStockPrice(trade);
			if(stockPrice > 0){
				stockPrices.add(stockPrice);
			}
		}
		
		if(stockPrices.size()>=1){
			double[] pricesArray = new double[stockPrices.size()];
			
			for(int i=0; i<=(stockPrices.size()-1); i++){
				pricesArray[i] = stockPrices.get(i).doubleValue();
			}

			gbce = StatUtils.geometricMean(pricesArray);
		}
		return gbce;
	}
}
