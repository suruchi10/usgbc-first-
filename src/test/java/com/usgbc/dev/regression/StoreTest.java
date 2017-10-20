package com.usgbc.dev.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.usgbc.dev.business.Store;
import com.usgbc.utility.Base;
import com.usgbc.utility.BrokenLink;

public class StoreTest extends Base {

	@Test	
	public void testStore() throws Exception {
		
		 String url ="http://test-dynamic-usgbc.pantheonsite.io/store";
		 driver.get(url);
		 System.out.println("Store Module Test");
		 System.out.println("Broken Link for /store ");
		 BrokenLink.BrokenLinkCheck(url);
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Store Module Test");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.StoreModule();
		    	System.out.println("Store Module Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}

}