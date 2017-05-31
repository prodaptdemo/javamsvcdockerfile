package com.prodapt.app.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.prodapt.app.controller.AppController;
import com.prodapt.app.dao.AppDao;
import com.prodapt.app.dao.impl.AppDaoImpl;
import com.prodapt.app.model.AppResponse;
import com.prodapt.app.service.AppService;


public class AppControllerTest {

	@InjectMocks
	private AppController appController;
	
	@Spy
	private AppService appService;
	
	@Spy
	private AppDaoImpl appDao;
	
	
	@Before
	public void setMocks() throws Exception
	{
		MockitoAnnotations.initMocks(this);
		appService.setAppDao(appDao);
		appController.setEaseYourWorkService(appService);
	}	
	
	@Test
	public void testAllData() throws Exception
	{
		AppResponse response = appController.getResult("");
		assertEquals("Success", response.getResponseCode());
		assertEquals("Records Found", response.getResponseMessage());
	}
	
	@Test
	public void testAllDataNullInput() throws Exception
	{
		AppResponse response = appController.getResult(null);
		assertEquals("Success", response.getResponseCode());
		assertEquals("Records Found", response.getResponseMessage());
	}
	
	@Test
	public void testInvalidInputData() throws Exception
	{
		AppResponse response = appController.getResult("Test User");
		assertEquals("Success", response.getResponseCode());
		assertEquals("No record found", response.getResponseMessage());
	}
	
	@Test
	public void testvalidInputData() throws Exception
	{
		AppResponse response = appController.getResult("Paytm");
		assertEquals("Success", response.getResponseCode());
		assertEquals("Records Found for the input:Paytm", response.getResponseMessage());
	}
	
	@Test
	public void testvalidThrowingException() throws Exception
	{
		
		AppDao dao = new AppDao() {			
			@Override
			public List<String[]> getResult(String appname) throws IOException {
				throw new IOException();
			}
		};
		appService.setAppDao(dao);
		appController.setEaseYourWorkService(appService);
		AppResponse response = appController.getResult("Paytm");
		assertEquals("Failure", response.getResponseCode());
		
	}
	
	
	
}
