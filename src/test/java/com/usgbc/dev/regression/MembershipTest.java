package com.usgbc.dev.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.usgbc.dev.business.Membership;
import com.usgbc.dev.business.Store;
import com.usgbc.utility.Base;
import com.usgbc.utility.BrokenLink;

public class MembershipTest extends Base{
	
	@Test	
	public void testMembership() throws Exception {
		
		 String url ="https://test-dynamic-usgbc.pantheonsite.io/membership/contact";
		 driver.get(url);
		 System.out.println("Membership Module ");
		 System.out.println("Broken Link for /membership/contact");
		 //BrokenLink.BrokenLinkCheck(url);
	     Membership membership = PageFactory.initElements(driver, Membership.class);    
		    try {
		    	test= extent.startTest("Membership Module");
		    	test.log(LogStatus.INFO, "Test Started");
		    	membership.MembershipModule();
		    	System.out.println("Memberships Module Test Finished ");
			}catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }
	}
}