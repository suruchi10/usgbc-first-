package com.usgbc.dev.business;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.usgbc.dev.page.UsgbcWebLocators;

public class ErrorMessageCommReg extends UsgbcWebLocators {
	
	
	public ErrorMessageCommReg(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void CommunityRegistrationErrorMessage () throws InterruptedException
	{
		String[] CommunityRegistrationErrorMsg = { 
			    "Street address field is required.", 
                "Street address line 2 field is required.", 
                "City field is required.", 
                "State field is required.",
                "Zip code field is required.",
                "Please mention how did you hear about the product.",
                "Please agree to our terms.",
               };
		 getContinue().click();
		 Thread.sleep(3000);
		 JavascriptExecutor js = ((JavascriptExecutor) driver);
		 //Thread.sleep(3000);
	     js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath(".//*[@id='edit-address']/div[3]/div[1]/label")));
	     Thread.sleep(3000);
	     List<WebElement> ErrorMsgSize =  driver.findElements(By.className("input-error-desc"));
	        System.out.println("***** "+ErrorMsgSize.size());
	        int i = 0;
	        for (WebElement ErrorMsg : ErrorMsgSize) {
	            System.out.println("**** "+ErrorMsg.getText());
	            if(ErrorMsg.getText().equals("")){
	               
	            	continue;
	            }
	            else
	                Assert.assertTrue(ErrorMsg.getText().contains(CommunityRegistrationErrorMsg[i]));
	                		//equalsIgnoreCase(CommunityRegistrationErrorMsg[i]));
	            
	            i++;
	        } 
		
	    
		 
	}
	
	public void CommunityRegistrationErrorMessageCondition2 () throws InterruptedException
	{
		String[] CommunityRegistrationErrorMsg = { 
			    "Street address field is required.", 
                "Street address line 2 field is required.", 
                "City field is required.", 
                "State field is required.",
                "Zip code field is required.",
                "Please enter your school.",
                "Please enter your student id",
                "Please enter your graduation date.",
                "Please mention how did you hear about the product.",
                "Please agree to our terms."
               }; 
		
		Thread.sleep(3000);
		List<WebElement>radioButton =driver.findElements(By.name("is_student")); 
	    boolean bValue = false;
	    bValue = radioButton.get(0).isSelected();
	    if(bValue = true){
	    	radioButton.get(1).click();
	    }
	    Thread.sleep(3000);
	    getContinue().click();
		Thread.sleep(3000);
		 List<WebElement> ErrorMsgSize =  driver.findElements(By.className("input-error-desc"));
	        System.out.println("***** "+ErrorMsgSize.size());
	        int i = 0;
	        for (WebElement ErrorMsg : ErrorMsgSize) {
	            System.out.println("**** "+ErrorMsg.getText());
	            if(ErrorMsg.getText().equals("")){
	               
	            	continue;
	            }
	            else
	                Assert.assertTrue(ErrorMsg.getText().contains(CommunityRegistrationErrorMsg[i]));
	                		//equalsIgnoreCase(CommunityRegistrationErrorMsg[i]));
	            
	            i++;
	        } 
		
	     
	}   
	
	public void CommunityRegistrationErrorMessageCondition3 () throws InterruptedException
	{
		String[] CommunityRegistrationErrorMsg = { 
			    "Street address field is required.", 
                "Street address line 2 field is required.", 
                "City field is required.", 
                "State field is required.",
                "Zip code field is required.",
                "Please enter your school.",
                "Please enter your student id",
                "Graduation date should be a future date.",
                "Please enter your birthday.",
	 			"Please describe briefly how did you hear about us.",
	 			"Please agree to our terms."};
			
		Thread.sleep(3000);
		List<WebElement>radioButton =driver.findElements(By.name("is_student")); 
	    boolean bValue = false;
	    bValue = radioButton.get(0).isSelected();
	    if(bValue = true){
	    	radioButton.get(1).click();
	    }
	    getGraduation().sendKeys("2017-02-06");
	    Thread.sleep(3000);
	    
	    List<WebElement>radioButton2 =driver.findElements(By.name("is_emerging_prof")); 
	    boolean bValue2 = false;
	    bValue2 = radioButton2.get(0).isSelected();
	    if(bValue2 = true){ 
	    	radioButton2.get(1).click();
	    	getBirthday().click();
	    	Thread.sleep(2000);
	    }
      
	    getOther().click();
	    
	    getContinue().click();
		Thread.sleep(3000);
		
		 List<WebElement> ErrorMsgSize =  driver.findElements(By.className("input-error-desc"));
		 System.out.println("***** "+ErrorMsgSize.size());
	        int i = 0;
	        for (WebElement ErrorMsg : ErrorMsgSize) {
	            System.out.println("**** "+ErrorMsg.getText());
	            if(ErrorMsg.getText().equals("")){
	               
	            	continue;
	            }
	            else
	                Assert.assertTrue(ErrorMsg.getText().contains(CommunityRegistrationErrorMsg[i]));
	                		//equalsIgnoreCase(CommunityRegistrationErrorMsg[i]));
	            i++;
	        } 
		
	   
	}   
		


}
