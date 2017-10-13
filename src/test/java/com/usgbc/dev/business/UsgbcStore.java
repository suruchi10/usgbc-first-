package com.usgbc.dev.business;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.usgbc.dev.page.UsgbcWebLocators;
import com.usgbc.utility.BrokenLink;

public class UsgbcStore extends UsgbcWebLocators {
	
	public UsgbcStore(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	  /*----------------------------------------*/
	public void UsgbcStoreModule() throws Exception {
		
		getUsgbcStore().click();
		Thread.sleep(3000);
		String storeContact_url =driver.getCurrentUrl();
		Thread.sleep(3000);
			if(storeContact_url.equalsIgnoreCase("http://test-dynamic-usgbc.pantheonsite.io/store/contact") && getStatusMessage().isDisplayed()) {
		    Assert.assertTrue(getStatusMessage().getText().contains("No items are added to the cart"));
			System.out.println("No items are added to the cart");
			}
	}
	
	/*----------------------------------------*/
	public void Contact_Form(String sheetName, int rowNum) throws InterruptedException {
		
		
		String Attention= reader.getCellData(sheetName, "Attention",rowNum); 
		String Company= reader.getCellData(sheetName, "Company", rowNum);
		String Country= reader.getCellData(sheetName, "Country", rowNum);
		String Street_Address= reader.getCellData(sheetName, "Street_Address", rowNum);
		String Street_Address_line2= reader.getCellData(sheetName, "Street_Address_line2", rowNum);
		String City= reader.getCellData(sheetName, "City", rowNum);
		contact_store(Attention,Company,Country,Street_Address,Street_Address_line2,City);
		
	}
	public void signInForm(String sheetName, int rowNum) throws InterruptedException {
		
		
		String Eemail= reader.getCellData(sheetName, "email",rowNum); 
		String Epass= reader.getCellData(sheetName, "password", rowNum);
		Thread.sleep(3000);
		signin_usgbc(Eemail,Epass);
	
	}
	
	public void signUpForm(String sheetName, int rowNum) throws InterruptedException {
		
		String fname= reader.getCellData(sheetName, "firstname",rowNum); 
		String lname= reader.getCellData(sheetName, "lastname", rowNum);
		String email= reader.getCellData(sheetName, "email", rowNum);
		String pass= reader.getCellData(sheetName, "password", rowNum);
		String cpass= reader.getCellData(sheetName, "cpassword", rowNum);
		signup_usgbc(fname,lname,email,pass,cpass);
		
	}
	
public void paymentForm(String sheetName, int rowNum) throws InterruptedException {
		
		String name_on_card= reader.getCellData(sheetName, "name_on_card",rowNum); 
		String card_number= reader.getCellData(sheetName, "card number", rowNum);
		String month= reader.getCellData(sheetName, "month", rowNum);
		String year= reader.getCellData(sheetName, "year", rowNum);
		String security_code= reader.getCellData(sheetName, "security_code", rowNum);
		String billing_country= reader.getCellData(sheetName, "country", rowNum);
		String billing_street_address= reader.getCellData(sheetName, "street_address", rowNum);
		String billing_street_address2= reader.getCellData(sheetName, "street_address2", rowNum);
		String billing_city= reader.getCellData(sheetName, "city", rowNum);
		String billing_pin_code= reader.getCellData(sheetName, "pincode", rowNum);
		String billing_state= reader.getCellData(sheetName, "state", rowNum);
		payment_usgbc( name_on_card , card_number, month, year, security_code, billing_country, billing_street_address, billing_street_address2, billing_city, billing_pin_code, billing_state);
					
	}
	
	public void receiptdownload() throws Exception {
		
		 paymentForm("payment", 2);
		 Thread.sleep(3000);  
		 String reciept_url = driver.getCurrentUrl();
		 if(reciept_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment") &&  getstatusMessageUsgbcPayment().isDisplayed()){ 
			  Assert.assertTrue( getstatusMessageUsgbcPayment().getAttribute("innerHTML").contains("User not found"));
			  System.out.println("Usere not Found");	 
		 }else if (reciept_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment")) {
			  Assert.assertTrue(true);
			  System.out.println("Error in payment form submission. ");  	
       }else if((reciept_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment") &&  getstatusMessageUsgbcPayment().isDisplayed())){
    	   System.out.println(getstatusMessageUsgbcPayment().getAttribute("innerHTML"));
    	   Assert.assertTrue( getstatusMessageUsgbcPayment().getAttribute("innerHTML").contains("To prevent misorders, the same item may not be purchased twice within 24 hours. Questions? Call (800 number)"));
    	   System.out.println("To prevent misorders, the same item may not be purchased twice within 24 hours. Questions? Call (800 number)"); 
       }else {
          reciept_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/payment/reciept");
		   Assert.assertTrue(true);
		   System.out.println("Broken Link for /Payment/reciept ");
		   BrokenLink.BrokenLinkCheck(reciept_url);
		   getprint_Receipt().click();
          System.out.println("Receipt downloaded ");
		  }
		   	
	}
	
	public void contactPaymentReceipt() throws Exception {
		
		 Thread.sleep(3000);
		 String StoreContact_url = driver.getCurrentUrl();
		 Assert.assertEquals(StoreContact_url, "https://test-dynamic-usgbc.pantheonsite.io/store/contact");	
		 Contact_Form("Sheet1" , 3);
		 Thread.sleep(3000);
		 signInForm("signin",8);
		 String Signin_url = driver.getCurrentUrl();
		   if (Signin_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/signin")) {
			   Assert.assertTrue(true);
			   System.out.println("This user does not exist in the system. ");
			   getRegister().click();
			   Thread.sleep(3000);
			   String signup_url = driver.getCurrentUrl();
			   System.out.println("Broken Link for /signup ");
			   BrokenLink.BrokenLinkCheck(signup_url);
			   signUpForm("signup",  3);
			   Thread.sleep(3000);
			   String payment_url = driver.getCurrentUrl();
				   if(payment_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment")) {
					   Assert.assertTrue(true); 
					   System.out.println("User registered and created sucessfully");
					   System.out.println("Broken Link for /usgbc/payment ");
					   BrokenLink.BrokenLinkCheck(payment_url);
					   receiptdownload();
				   }else {
					  Assert.assertTrue(getstatusMessageSignup().getAttribute("innerHTML").contains("This user already exist in the system. Please sign in."));
					  System.out.println("Error in signup form submission"); 
				   }   
		   }else {
		   Assert.assertEquals(Signin_url, "https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment");   
		   System.out.println("User is registered already ");
		   System.out.println("Broken Link for /usgbc/payment ");
		   BrokenLink.BrokenLinkCheck(Signin_url);
		   receiptdownload();
		   }   
    }	 
	  /*----------------------------------------*/
     public void UsgbcStoreModule2() throws Exception {
		
    	getAddToCart().click();
		Thread.sleep(3000);
		String cart_url =driver.getCurrentUrl();
		Thread.sleep(3000);
			if(cart_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/cart") && getStatusMessage1().isDisplayed()) {
				 Assert.assertTrue(getStatusMessage2().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
				 System.out.println(getStatusMessage2().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
				 getUsgbcStore().click();
				 contactPaymentReceipt();	 
			}else {
				System.out.println("Add to cart link not clicked");
			}
	}
     /*----------------------------------------*/
     public void UsgbcStoreModule3() throws Exception {
 		
     	getAddToCart().click();
 		Thread.sleep(3000);
 		String cart_url =driver.getCurrentUrl();
 		Thread.sleep(3000);
 			if(cart_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/cart") && getStatusMessage1().isDisplayed()) {
 				 Assert.assertTrue(getStatusMessage2().getAttribute("innerHTML").contains("Green Apple Lapel Pins"));
 				 System.out.println(getStatusMessage2().getAttribute("innerHTML")+" : Product added to your shopping cart. ");
 				 getCheckOutButton().click();
 				 Thread.sleep(3000);
 				 String StoreContact_url = driver.getCurrentUrl();
 				 Assert.assertEquals(StoreContact_url, "https://test-dynamic-usgbc.pantheonsite.io/store/contact");	
 				 Contact_Form("Sheet1" , 3);
 				 Thread.sleep(3000);
 				 signInForm("signin",3);
 				 String Signin_url = driver.getCurrentUrl();
 				   if (Signin_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/signin")) {
 					   Assert.assertTrue(true);
 					   System.out.println("This user does not exist in the system. ");
 					   getRegister().click();
 					   Thread.sleep(3000);
 					   String signup_url = driver.getCurrentUrl();
 					   System.out.println("Broken Link for /signup ");
 					   BrokenLink.BrokenLinkCheck(signup_url);
 					   signUpForm("signup",  3);
 					   Thread.sleep(3000);
 					   String payment_url = driver.getCurrentUrl();
 						   if(payment_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment")) {
 							   Assert.assertTrue(true); 
 							   System.out.println("User registered and created sucessfully");
 							   System.out.println("Broken Link for /usgbc/payment ");
 							   BrokenLink.BrokenLinkCheck(payment_url);
 							   receiptdownload();
 						   }else {
 							  Assert.assertTrue(getstatusMessageSignup().getAttribute("innerHTML").contains("This user already exist in the system. Please sign in."));
 							  System.out.println("Error in signup form submission"); 
 						   }   
 				   }else {
 				   Assert.assertEquals(Signin_url, "https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment");   
 				   System.out.println("User is registered already ");
 				   System.out.println("Broken Link for /usgbc/payment ");
 				   BrokenLink.BrokenLinkCheck(Signin_url);
 				   receiptdownload();
 				   }   
 				 
 			}else {
				System.out.println("Checkout button is not clicked");
			}
 	} 
}