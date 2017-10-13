package com.usgbc.dev.business;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.usgbc.dev.page.UsgbcWebLocators;

public class LoggedUser extends UsgbcWebLocators {
	
	 public LoggedUser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 
	public  void loggedUserVerification() throws InterruptedException {
	    Thread.sleep(4000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='main-menu']/li[4]/a")));
	        try {
	        	
		        if(driver.findElement(By.linkText("Sign out")).isDisplayed()) {
		        	System.out.println("user is logged in");
		        }
	        }
	        catch(Exception e) {
	        	System.out.println("user is not logged in");
	        	
	        }
	   }
	
	
	
	public void signInForm(String sheetName, int rowNum) throws InterruptedException {
		
		
		String Eemail= reader.getCellData(sheetName, "email",rowNum); 
		String Epass= reader.getCellData(sheetName, "password", rowNum);
		Thread.sleep(3000);
		signin_usgbc(Eemail,Epass);
	
	}
	
	public  void loggedUserVerification2() throws InterruptedException {
	    Thread.sleep(4000);
	    getUsgbcCore().click();
	    Thread.sleep(3000);
	    signInForm("signin",2);	
	    Thread.sleep(3000);
	    getCommunityRegistration().click();
	    Thread.sleep(3000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='main-menu']/li[4]/a")));
	        try {
	        	
		        if(driver.findElement(By.linkText("Sign out")).isDisplayed()) {
		        	System.out.println("user is logged in");
		        }
	        }
	        catch(Exception e) {
	        	System.out.println("user is not logged in");
	        	
	        }
	   }	

}
	
   