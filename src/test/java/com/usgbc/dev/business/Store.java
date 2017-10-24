package com.usgbc.dev.business;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.usgbc.utility.ReusableMethods;

public class Store extends ReusableMethods{
	
	public Store(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		//getLEED_Reference()
	}

	public void StoreModule() throws Exception {
		
		getGreenAppleLapelPins().click();
		Thread.sleep(3000);
		String GreenAppleLapelPins_url = driver.getCurrentUrl();
			 if((GreenAppleLapelPins_url.equalsIgnoreCase("http://test-dynamic-usgbc.pantheonsite.io/node/31")) && driver.getTitle().contains("Green Apple Lapel Pins")) {
			 Assert.assertTrue(true);
			 getAddToCartGreen().click();
			 Thread.sleep(3000);
		     String Cart_url = driver.getCurrentUrl();
		     		if((Cart_url.equalsIgnoreCase("http://test-dynamic-usgbc.pantheonsite.io/cart"))&& driver.getTitle().contains("Shopping cart")) { 
		     			 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
						 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
						 getUsgbcStore().click();
						 Thread.sleep(3000);
						 String StoreContact_url = driver.getCurrentUrl();
						 Assert.assertEquals(StoreContact_url, "http://test-dynamic-usgbc.pantheonsite.io/store/contact");	
						 Contact_Form("Sheet1" , 3);
						 Thread.sleep(3000);
						 signInForm("signin",3);
						 contactPaymentReceipt();
				 		
					}else {
						System.out.println("Add to cart is link is not clicked");
						System.out.println("......"+ Cart_url  + "......" );
					}
			 }else {
		    	 
		    	 System.out.println("Green Apple Lapel Pins product not clicked");
				 System.out.println("......"+ GreenAppleLapelPins_url + "......" );
		     	
		     }
		}
}
