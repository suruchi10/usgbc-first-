package com.usgbc.dev.business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.usgbc.utility.ReusableMethods;

public class Membership extends ReusableMethods {
	
public Membership(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public void membership() throws Exception {
	 getOrganistionName().sendKeys("Group10");
	 getwebsite().sendKeys("www.test.com");
	 Select select = new Select(getIndustryCategory());
	    select.selectByVisibleText("Educational Institutions");
	    Thread.sleep(3000);
	 Select select2 = new Select(getIndustrySubCategory());
	    select2.selectByVisibleText("Commissioning Providers");
	    Thread.sleep(3000);
	 Select select3 = new Select(getRevenueScale());
	    select3.selectByVisibleText("Less than $250,000");
	    Thread.sleep(3000);
	    getContactContinue().click();
	 
}

public void MembershipModule() throws Exception {
	
		Assert.assertTrue(getContactinfo().getText().contains("Click here to Sign in"));
		System.out.println("User not logged in");
	    getMembershipSignin().click();
		Thread.sleep(3000);
		String MembershipSignin_url = driver.getCurrentUrl();
		 if (MembershipSignin_url.equals("https://test-dynamic-usgbc.pantheonsite.io/signin?destination=/membership/contact")) {
			 Assert.assertTrue(true);
			 signInForm("signin",7);
			 String Signin_url = driver.getCurrentUrl();
			   if (Signin_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/signin?destination=/membership/contact") && getUserNotExist().isDisplayed()){
				   Assert.assertTrue( getUserNotExist().getText().contains("This user does not exist in the system")); 
				   System.out.println("This user does not exist in the system.");
				   getRegister().click();
				   signUpForm("signup",7);
				   Thread.sleep(3000);
				   String membershipContatct_url = driver.getCurrentUrl();
				   if(membershipContatct_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/membership/contact")) {
					   Assert.assertTrue(true);
					   System.out.println("User registration is successful");
					   Contact_Form("Sheet1" , 3);
					   membership();
					   Assert.assertEquals( driver.getCurrentUrl(),"https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment");
					   receiptdownload();
				   }else {
					   System.out.println("User registration is not successful");
				   }
			   }else {
				   Assert.assertEquals(Signin_url, "https://test-dynamic-usgbc.pantheonsite.io/membership/contact");
				   Assert.assertTrue(getContactinfo().getText().contains("You are signed in as"));
				   System.out.println("Signin successful"); 
				   Contact_Form("Sheet1" , 3);
				   membership();
				   Assert.assertEquals( driver.getCurrentUrl(),"https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment");
				   receiptdownload();
			   }
		 }else
		 {
			 System.out.println("Signin link not working or clicked");
		 }
	}
}