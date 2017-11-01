package com.usgbc.dev.business;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.usgbc.utility.ReusableMethods;

public class UsgbcStore extends ReusableMethods {
	
	
	  public UsgbcStore(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*----------------------------------------*/
	public void UsgbcStoreModule() throws Exception {
		
		getUsgbcStore().click();
		Thread.sleep(3000);
		String storeContact_url =driver.getCurrentUrl();
		//System.out.println(storeContact_url);
		Thread.sleep(3000);
		 if (storeContact_url.equals("https://test-dynamic-usgbc.pantheonsite.io/store/contact")&& getStatusMessageNoItemsAdded().isDisplayed()) {
			 Assert.assertTrue(getStatusMessageNoItemsAdded().getText().contains("No items are added to the cart"));
			 System.out.println("No Items are added to the cart");
		 }
		 else
		 {
			 System.out.println(" It is going to else condition ");
		 }
	}
	
	  /*----------------------------------------*/
	
     public void UsgbcStoreModuleGreen() throws Exception {
		
    	getAddToCartGreen().click();
		Thread.sleep(3000);
		String cart_url =driver.getCurrentUrl();
		Thread.sleep(3000);
			if(cart_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/cart") && getStatusMessageBlock().isDisplayed()) {
				 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
				 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
				 getUsgbcStore().click();
				 Thread.sleep(3000);
				 String StoreContact_url = driver.getCurrentUrl();
				 Assert.assertEquals(StoreContact_url, "https://test-dynamic-usgbc.pantheonsite.io/store/contact");	
				 System.out.println("*****contact-payment-receipt*****");
				 Contact_Form("Sheet1" , 3);
				 Thread.sleep(3000);
				 signInForm("signin",8);
				 contactPaymentReceipt();	 
			}else {
				System.out.println("Add to cart link not clicked");
				System.out.println("......"+ driver.getCurrentUrl() + "......" );
			}
	}
     /*----------------------------------------*/
     
     public void UsgbcStoreModuleGreen2() throws Exception {
 		
     	getAddToCartGreen().click();
 		Thread.sleep(3000);
 		String cart_url =driver.getCurrentUrl();
 		Thread.sleep(3000);
 			if(cart_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/cart") && getStatusMessageBlock().isDisplayed()) {
 				 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
 				 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
 				 getCheckOutButton().click();
 				 Thread.sleep(3000);
 				 String StoreContact_url = driver.getCurrentUrl();
 				 Assert.assertEquals(StoreContact_url, "https://test-dynamic-usgbc.pantheonsite.io/store/contact");	
 				 System.out.println("******contact-payment-receipt*****");
 				 Contact_Form("Sheet1" , 3);
 				 Thread.sleep(3000);
 				 signInForm("signin",9);
 				 contactPaymentReceipt();
 				 
 			}else {
				System.out.println("Add to cart link not clicked");
				 System.out.println("......"+ driver.getCurrentUrl() + "......" );
			}
 	} 
     
     /*----------------------------------------*/
     public void UsgbcStoreModuleLEED() throws Exception {
 		
    	 getAddToCartLEED().click();
 		Thread.sleep(3000);
 		String cart_url =driver.getCurrentUrl();
 		Thread.sleep(3000);
 			if(cart_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/cart") && getStatusMessageBlock().isDisplayed()) {
 				 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("LEED Reference Guide for Homes Design and Construction (e-document)"));
 				 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
 				 getUsgbcStore().click();
 				 Thread.sleep(3000);
 				 String StoreContact_url = driver.getCurrentUrl();
 				 Assert.assertEquals(StoreContact_url, "https://test-dynamic-usgbc.pantheonsite.io/store/contact");	
 				 System.out.println("*****contact-payment-receipt*****");
 				 //Contact_Form("Sheet1" , 3);
 				 getWebsite().click();
 				 getContinue().click();
 				 Thread.sleep(3000);
 				 signInForm("signin",8);
 				 contactPaymentReceipt();	 
 			}else {
 				System.out.println("Add to cart link not clicked");
 				System.out.println("......"+ driver.getCurrentUrl() + "......" );
 			}
 	}
      /*----------------------------------------*/
     
      public void UsgbcStoreModuleLEED2() throws Exception {
  		
    	getAddToCartLEED().click();
  		Thread.sleep(3000);
  		String cart_url =driver.getCurrentUrl();
  		Thread.sleep(3000);
  			if(cart_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/cart") && getStatusMessageBlock().isDisplayed()) {
  				 Assert.assertTrue(getStatusMessage().getAttribute("innerHTML").contains("LEED Reference Guide for Homes Design and Construction (e-document)"));
  				 System.out.println(getStatusMessage().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
  				 getCheckOutButton().click();
  				 Thread.sleep(3000);
  				 String StoreContact_url = driver.getCurrentUrl();
  				 Assert.assertEquals(StoreContact_url, "https://test-dynamic-usgbc.pantheonsite.io/store/contact");	
  				 System.out.println("*****contact-payment-receipt*****");
  				 // Contact_Form("Sheet1" , 3);
  				 getWebsite().click();
  				 getContinue().click();
  				 Thread.sleep(3000);
  				 signInForm("signin",9);
  				 contactPaymentReceipt();
  				 
  			}else {
 				System.out.println("Add to cart link not clicked");
 				System.out.println("......"+ driver.getCurrentUrl() + "......" );
 			}
  	} 
}