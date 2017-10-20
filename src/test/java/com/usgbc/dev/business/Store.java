package com.usgbc.dev.business;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.usgbc.dev.page.UsgbcWebLocators;
import com.usgbc.utility.BrokenLink;
import com.usgbc.utility.ReusableMethods;

public class Store extends ReusableMethods{
	
	public Store(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		//getLEED_Reference()
	}
//23-24, 28-29
	public void StoreModule() throws Exception {
		
		getGreenAppleLapelPins().click();
		Thread.sleep(3000);
		String GreenAppleLapelPins_url = driver.getCurrentUrl();
			 if((GreenAppleLapelPins_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/node/31")) && driver.getTitle().contains("Green Apple Lapel Pins |")) {
			 Assert.assertTrue(true);
			 getAddToCartGreen().click();
			 Thread.sleep(3000);
		     String Cart_url = driver.getCurrentUrl();
//		     String statusMessage="Green Apple Lapel Pins added to your shopping cart.";
		     		if((Cart_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/cart"))) { 
		     			 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
						 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
						 getUsgbcStore().click();
						 Thread.sleep(3000);
						 String StoreContact_url = driver.getCurrentUrl();
						 Assert.assertEquals(StoreContact_url, "https://test-dynamic-usgbc.pantheonsite.io/store/contact");	
						 Contact_Form("Sheet1" , 3);
						 Thread.sleep(3000);
						 signInForm("signin",8);
						 contactPaymentReceipt();	 
				 		
					}else {
						System.out.println("Store/contact ilink is not clicked");
						System.out.println("......"+ driver.getCurrentUrl() + "......" );
					}
			 }
		     else {
		    	 
		    	 System.out.println("Add to cart link not clicked");
				 System.out.println("......"+ driver.getCurrentUrl() + "......" );
		     	
		     }
		}
}
