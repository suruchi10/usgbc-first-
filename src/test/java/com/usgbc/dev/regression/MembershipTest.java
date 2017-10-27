package com.usgbc.dev.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.usgbc.dev.business.Store;
import com.usgbc.utility.Base;
import com.usgbc.utility.BrokenLink;

public class MembershipTest extends Base{
	
	@Test	
	public void testStore() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/membership/contact";
		 driver.get(url);
		 System.out.println("Membership Module ");
		 System.out.println("Broken Link for /membership/contact");
		 BrokenLink.BrokenLinkCheck(url);
	     Store store = PageFactory.initElements(driver, Store.class);    
		    try {
		    	test= extent.startTest("Membership Module");
		    	test.log(LogStatus.INFO, "Test Started");
		    	store.StoreModule();
		    	System.out.println("Memberships Module Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
}