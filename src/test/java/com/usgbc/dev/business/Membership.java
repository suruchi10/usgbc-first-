package com.usgbc.dev.business;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.usgbc.utility.ReusableMethods;

public class Membership extends ReusableMethods {
	
public Membership(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public void UsgbcStoreModule() throws Exception {
	
		Assert.assertTrue(getMembershipSignin().getText().contains("Click here to"));
		System.out.println("User not logged in");
	    getMembershipSignin().click();
		Thread.sleep(3000);
		String MembershipSignin_url = driver.getCurrentUrl();
		 if (MembershipSignin_url.equals("http://test-dynamic-usgbc.pantheonsite.io/signin?destination=/membership/contact")) {
			 Assert.assertTrue(true);
			 signInForm("signin",9);
			 String Signin_url = driver.getCurrentUrl();
			   if (Signin_url.equalsIgnoreCase("http://test-dynamic-usgbc.pantheonsite.io/signin?destination=/membership/contact") && getUserNotExist().isDisplayed()){
				   Assert.assertTrue( getstatusMessageUsgbcPayment().getAttribute("innerHTML").contains("This user does not exist in the system. "),"This user does not exist in the system."); 
				   System.out.println("This user does not exist in the system. ");
				   getRegister().click();
				   signUpForm("signup", 10);
				   Thread.sleep(3000);
				   String membershipContatct_url = driver.getCurrentUrl();
				   if(membershipContatct_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/membership/contact")) {
					   Assert.assertTrue(true);
					   System.out.println("User registration is successful");
					   Contact_Form("Sheet1" , 3);
					   //
				   }else {
					   System.out.println("User registration is not successful");
				   }
			   }else {
				   Assert.assertEquals(Signin_url, "http://test-dynamic-usgbc.pantheonsite.io/membership/contact");
				    System.out.println("User already Registered. "); 
				    Contact_Form("Sheet1" , 3);
				    //
			   }
			
		 }
		 else
		 {
			 System.out.println("Signin link not working or clicked");
		 }
	}
}