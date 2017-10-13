package com.usgbc.dev.business;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.usgbc.dev.page.UsgbcWebLocators;
import com.usgbc.utility.BrokenLink;

public class Store extends UsgbcWebLocators{
	
	public Store(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void StoreModule() throws Exception {
		
		getGreenAppleLapelPins().click();
		Thread.sleep(3000);
		String GreenAppleLapelPins_url = driver.getCurrentUrl();
		String expectedTitle = "Green Apple Lapel Pins | ";
		if((GreenAppleLapelPins_url.equalsIgnoreCase("http://test-dynamic-usgbc.pantheonsite.io/node/30")) && driver.getTitle().contains(expectedTitle)) {
			 Assert.assertTrue(true);
			 BrokenLink.BrokenLinkCheck(GreenAppleLapelPins_url);
			 getAddToCart().click();
			 Thread.sleep(3000);
			
		     String Cart_url = driver.getCurrentUrl();
		     String expectedCartTitle="Shopping cart |";
		     String statusMessage="Green Apple Lapel Pins added to your shopping cart.";
		     		if((Cart_url.equalsIgnoreCase("http://test-dynamic-usgbc.pantheonsite.io/cart")) && driver.getTitle().contains(expectedCartTitle)) {
		     			 Assert.assertTrue(true);
		     			 System.out.println("Products added in the cart");
		     			 //System.out.println(".."+ getStatusMessgae().getText()== statusMessage);
		   			     BrokenLink.BrokenLinkCheck(Cart_url);	
		     		}else {
		     			System.out.println("......"+driver.getCurrentUrl()  + "......" );
		     		}
		}else {
			
			 System.out.println("......"+ driver.getCurrentUrl() + "......" );
			
		}    
		
	}

}
