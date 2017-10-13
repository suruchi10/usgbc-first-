package com.usgbc.dev.regression;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.usgbc.utility.Base;

public class CommunityRegistrationCountryFieldTest extends Base{

	@Test	
	public void testCommunityRegistrationCountryField() throws Exception {
	
		System.out.println("Communtiy Registration Module for country Field Validation");
		//System.out.println("Broken Link for communtiy/registration ");
		   
	    try {
	    	test= extent.startTest("Communtiy Registration Module for country Field Validation");
	    	test.log(LogStatus.INFO, "Test Started");
	    	Assert.assertTrue(true);	
	    	System.out.println("Communtiy Registration Module for country Field Validation Test Finished");
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			 }	
	}
}