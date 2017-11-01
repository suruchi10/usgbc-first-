package com.usgbc.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.usgbc.dev.page.UsgbcWebLocators;


public class ReusableMethods extends UsgbcWebLocators{

	
	public ReusableMethods(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
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
			  if(getstatusMessageUsgbcPayment().getAttribute("innerHTML").contains("User not found")) {
				  	Assert.assertTrue(true);
				  	System.out.println("User not Found");  
		        }else if( getstatusMessageUsgbcPayment().getAttribute("innerHTML").contains("To prevent misorders, the same item may not be purchased twice within 24 hours. Questions? Call (800 number)")) {
		        	Assert.assertTrue(true);
		        	System.out.println("To prevent misorders, the same item may not be purchased twice within 24 hours. Questions? Call (800 number)"); 
		 		}
		 }else if (reciept_url.equals("https://test-dynamic-usgbc.pantheonsite.io/usgbc/payment")) {
			  Assert.assertTrue(true);
			  System.out.println("Error in payment form submission. ");  	
	     }else {  
	          reciept_url.equals("https://test-dynamic-usgbc.pantheonsite.io/payment/reciept");
			  Assert.assertTrue(true);
			  System.out.println("Broken Link for /Payment/reciept ");
			  BrokenLink.BrokenLinkCheck(reciept_url);
			  getprint_Receipt().click();
	          System.out.println("Receipt downloaded ");
		
	     }   	
	}
	
	public void contactPaymentReceipt() throws Exception {
			
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
	
	public void numberOfRowsAndColumnInTable() {
		
		  List<WebElement> rows_table = driver.findElements(By.tagName("tr"));
		    //To calculate no of rows In table.
		    int rows_count = rows_table.size();

		    //Loop will execute till the last row of table.
		    for (int row=1; row<rows_count; row++){
		    //To locate columns(cells) of that specific row.
		    List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
		    //To calculate no of columns(cells) In that specific row.
		    int columns_count = Columns_row.size();
		    System.out.println("Number of cells In Row "+row+" are "+columns_count);

		    //Loop will execute till the last cell of that specific row.
		    for (int column=0; column<columns_count; column++){
		    //To retrieve text from that specific cell.
		        String celtext = Columns_row.get(column).getText();
		        System.out.println("Cell Value Of row number "+row+" and column number "+column+" Is "+celtext);
		    }
		    System.out.println("--------------------------------------------------");	
      }
	}
	
	public void StatusMessage() {
		if(getStatusMessageBlock().isDisplayed()) {
			System.out.println("---" +  getStatusMessageBlock().getText()+"---");
		}
	}

}
