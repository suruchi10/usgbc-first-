package com.usgbc.dev.regression;

import com.relevantcodes.extentreports.LogStatus;
import com.usgbc.dev.business.CommunityRegistration;
import com.usgbc.utility.Base;
import com.usgbc.utility.BrokenLink;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommunityRegistrationTest extends Base {
	
	
	@Test
	public void testCommunityRegistration() throws Exception {
		
		String url ="https://test-dynamic-usgbc.pantheonsite.io";
		driver.get(url);
		System.out.println("Communtiy Registration Module");
		System.out.println("Broken Link for / ");
		//BrokenLink.BrokenLinkCheck(url);
	    CommunityRegistration communityRegistration = PageFactory.initElements(driver, CommunityRegistration.class);    
	    try {
	    	test= extent.startTest("Communtiy Registration Module");
	    	test.log(LogStatus.INFO, "Test Started");
	    	communityRegistration.CommunityRegistartionModule();
	    	System.out.println("Communtiy Registration Module Test Finished");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		 }
	
	}
	
	
}
