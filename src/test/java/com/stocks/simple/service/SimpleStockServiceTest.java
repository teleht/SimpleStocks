package com.stocks.simple.service;

import org.apache.log4j.Logger;

import com.stocks.simple.model.Stock;
import com.stocks.simple.model.StockType;

import junit.framework.TestCase;

public class SimpleStockServiceTest extends TestCase {

	Logger logger = Logger.getLogger(SimpleStockServiceTest.class);
	
	public void testGetInstance() {
		
		logger.info("Start  SimpleStockService Test ...");

		SimpleStockService instanceA = SimpleStockService.getInstance();
		SimpleStockService instanceB = SimpleStockService.getInstance();

		assertNotNull(instanceA);
		assertNotNull(instanceB);

		assertTrue(instanceA.equals(instanceB));

		logger.info("Finish SimpleStockService Test ...OK");
	}
	
	public void testPutStock() {
		
		logger.info("Start  PutStock Test ...");
		
		SimpleStockService service = SimpleStockService.getInstance();
		
		Stock tea = new Stock();
		Stock pop = new Stock();
		Stock ale = new Stock();
		Stock gin = new Stock();
		Stock joe = new Stock();
		
		tea.setSymbol("TEA");
		tea.setType(StockType.COMMON);
		tea.setLastDividend(0);
		tea.setParValue(100);
		
		logger.info("Finish PutStock Test ...OK");
	}

}
