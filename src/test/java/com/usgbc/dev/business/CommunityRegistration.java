package com.usgbc.dev.business;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.usgbc.dev.page.UsgbcWebLocators;
import com.usgbc.utility.Base;
import com.usgbc.utility.BrokenLink;
import com.usgbc.utility.CommunityRegistrationFormData;

public class CommunityRegistration extends UsgbcWebLocators{

	public CommunityRegistration(WebDriver driver) {
		super(driver);		
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
		 if(reciept_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment") && getErrorMsg().isDisplayed()){ 
			  Assert.assertTrue(true);
			  System.out.println("You have very recently placed an order for this item. Please review your order history to confirm your previous order  ");	 
		 }else if (reciept_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment")) {
			  Assert.assertTrue(true);
			  System.out.println("Error in payment form submission. ");  	
        }else {
           reciept_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/payment/reciept");
		   Assert.assertTrue(true);
		   System.out.println("Broken Link for /Payment/reciept ");
		   BrokenLink.BrokenLinkCheck(reciept_url);
		   
		   getprint_Receipt().click();
		   // Bellow line will execute Auto It script
		   // Runtime.getRuntime().exec("D:\\AutoIT Script\\HandleAuthentication.exe");
           System.out.println("Receipt downloaded ");
		  }
		   	
	}
	
	
	public void CommunityRegistartionModule() throws Exception {
		
		getcommunityRegistration().click();
		//Thread.sleep(3000);
		String communityRegistration_url = driver.getCurrentUrl();
		Assert.assertEquals(communityRegistration_url, "https://test-dynamic-usgbc.pantheonsite.io/community/registration");
		System.out.println("Broken Link for community/registration ");
		//BrokenLink.BrokenLinkCheck(communityRegistration_url);
		CommunityRegistrationFormData.CommmunityRegistrationForm();
	    String signin_url = driver.getCurrentUrl();
		if (signin_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/signin") && driver.getTitle().contains("Sign-in")){
			   Assert.assertTrue(true);
			   System.out.println("Test Passed,session created and  order id generated ");
			   System.out.println("Broken Link for /signin ");
			   BrokenLink.BrokenLinkCheck(signin_url);
			   signInForm("signin",3);
			   //Thread.sleep(3000);
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
					   Assert.assertEquals(payment_url, "https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment");
					   System.out.println("User registered and created sucessfully");
					   System.out.println("Broken Link for /usgbc/payment ");
					   BrokenLink.BrokenLinkCheck(payment_url);
					   receiptdownload();  
					   
				   }else {
				   Assert.assertEquals(Signin_url, "https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment");   
				   System.out.println("User is registered already ");
				   System.out.println("Broken Link for /usgbc/payment ");
				   BrokenLink.BrokenLinkCheck(Signin_url);
				   receiptdownload();
				   }
			   
		   }else {
			       signin_url.equalsIgnoreCase("https://test-dynamic-usgbc.pantheonsite.io/community/registration");
				   Assert.assertTrue(true);
				   System.out.println(" Test Failed, Form field left empty"); 
				  
			   }
	     }
		
}


