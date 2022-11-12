package tn.esprit.rh.achat.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;



@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StockServiceImplTest {
	
	@InjectMocks
	static StockServiceImpl stockServiceImpl;
	@Mock
	static StockRepository stockRepository;
	static List<Stock> stocks;
	
	
	@BeforeEach
	 void init() {
		MockitoAnnotations.openMocks(this);
		stocks =  new ArrayList<>();
		when(stockRepository.findAll()).thenReturn(stocks);
	}
	
	@Test
	@Order(2)
	void testRetrieveAllStocks(){
		assertTrue(stockServiceImpl.retrieveAllStocks().isEmpty());
		
		stocks.add(mock(Stock.class));
		
		assertFalse(stockServiceImpl.retrieveAllStocks().isEmpty());

		
	}
	
	@Test
	@Order(1)
	void testAddStock(){
		stockServiceImpl.addStock(mock(Stock.class));

		verify(stockRepository).save(any());
		

		
	}
	
	@Test
	@Order(3)
	void testUpdateStock(){
		stockServiceImpl.updateStock(mock(Stock.class));

		verify(stockRepository).save(any());
		

		
	}
	
	

}