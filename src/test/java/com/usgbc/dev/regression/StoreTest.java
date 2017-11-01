package com.usgbc.dev.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.usgbc.dev.business.Store;
import com.usgbc.utility.Base;
import com.usgbc.utility.BrokenLink;

public class StoreTest extends Base {

	@Test	
	public void testStoreGreen() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/store";
		 driver.get(url);
		 System.out.println("Store Module Green Apple Lapel Pins");
		 System.out.println("Broken Link for /store ");
		 BrokenLink.BrokenLinkCheck(url);
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Store Module Green Apple Lapel Pins  ");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.StoreModuleGreen();
		    	System.out.println("Store Module Green Apple Lapel Pins Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
	
	@Test	
	public void testStoreLEED() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/store";
		 driver.get(url);
		 System.out.println("Store Module LEED Reference Guide for Homes Design and Construction (e-document)");
		 System.out.println("Broken Link for /store ");
		 BrokenLink.BrokenLinkCheck(url);
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Store Module LEED Reference Guide for Homes Design and Construction (e-document)");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.StoreModuleLEED();
		    	System.out.println("Store Module LEED Reference Guide for Homes Design and Construction (e-document) Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}

	@Test	
	public void testShoppingCartLink() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Shopping Cart link");
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Shopping Cart link");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.VerifyingShoppingCartLink();
		    	System.out.println("Shopping Cart Link Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
	
	@Test	
	public void testShoppingCartLink2() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Shopping Cart link");
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Shopping Cart link");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.VerifyingShoppingCartLink2();
		    	System.out.println("Shopping Cart Link Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
	
	@Test	
	public void testShoppingCartLink3() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Shopping Cart link");
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Shopping Cart link ");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.VerifyingShoppingCartLink3();
		    	System.out.println("Shopping Cart Link Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
}