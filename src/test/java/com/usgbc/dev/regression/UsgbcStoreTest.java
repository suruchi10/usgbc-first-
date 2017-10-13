package com.usgbc.dev.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.usgbc.dev.business.UsgbcStore;
import com.usgbc.utility.Base;
import com.usgbc.utility.BrokenLink;

public class UsgbcStoreTest extends Base {
	@Test	
	public void testUsgbcStore() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Usgbc Store Module");
		 System.out.println("Broken Link for store/contact ");
	     BrokenLink.BrokenLinkCheck(url);
	     UsgbcStore usgbcStore = PageFactory.initElements(driver, UsgbcStore.class);    
		    try {
		    	test= extent.startTest("Usgbc Store Module");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcStore.UsgbcStoreModule();
	 	    	System.out.println("Usgbc Store Module Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }	
	}
	
	@Test	
	public void testUsgbcStore2() throws Exception {
	
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Usgbc Store Module scenario 2");
		 System.out.println("Broken Link for / ");
	     BrokenLink.BrokenLinkCheck(url);
	     UsgbcStore usgbcStore = PageFactory.initElements(driver, UsgbcStore.class);    
		    try {
		    	test= extent.startTest("Usgbc Store Module scenario 2");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcStore.UsgbcStoreModule2();
		    	System.out.println("Usgbc Store Module scenario 2 Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }	
	}
	
	@Test	
	public void testUsgbcStore3() throws Exception {
	
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/";
		 driver.get(url);
		 System.out.println("Usgbc Store Module scenario 3");
		 System.out.println("Broken Link for / ");
	     BrokenLink.BrokenLinkCheck(url);
	     UsgbcStore usgbcStore = PageFactory.initElements(driver, UsgbcStore.class);    
		    try {
		    	test= extent.startTest("Usgbc Store Module scenario 3");
		    	test.log(LogStatus.INFO, "Test Started");
		    	usgbcStore.UsgbcStoreModule3();
		    	System.out.println("Usgbc Store Module scenario 3 Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }	
		
	}
}