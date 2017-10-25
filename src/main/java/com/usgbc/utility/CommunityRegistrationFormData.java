package com.usgbc.utility;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.usgbc.dev.page.UsgbcWebLocators;

public class CommunityRegistrationFormData extends UsgbcWebLocators {
	
	public CommunityRegistrationFormData(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void CommmunityRegistrationForm() throws InterruptedException {
		
		//for selecting community name
	
		Select community = new Select(getCommunity_Name());
		community.selectByIndex(2);
		
		//for selecting country
		Select country = new Select(getCountry());
		country.selectByIndex(104);
		Thread.sleep(5000);
	
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		Thread.sleep(2000);
		
		// for street address
		getStreet_Address().sendKeys("green street");
		getStreet_Address2().sendKeys("red wood");

		//for city
     	getCity().sendKeys("gurgaon");

       // for zip code
		getZip_code().sendKeys("122001");
		Thread.sleep(2000);
		
		//for state
		//getState().click();
		Select state= new Select(getState());
		state.selectByIndex(8);
		
		
		//for full time student  radio button
	    List<WebElement>radioButton =driver.findElements(By.name("is_student")); 
	    boolean bValue = false;
	    bValue = radioButton.get(0).isSelected();
	    if(bValue = true){
	    	radioButton.get(1).click();
	    	getSchool().clear();
			getSchool().sendKeys("Carmel");
		    getStudent_ID().clear();
			getStudent_ID().sendKeys("12");
			getGraduation().clear();
			getGraduation().sendKeys("2020-05-21");		
		 }else {
			radioButton.get(0).click();	
		}
	
		//for emerging professional radio button
	    List<WebElement>radioButton2 =driver.findElements(By.name("is_emerging_prof")); 
	    boolean bValue2 = false;
	    bValue2 = radioButton2.get(0).isSelected();
	    if(bValue2 = true){ 
	    	radioButton2.get(1).click();
	    	getBirthday().clear();
	    	getBirthday().sendKeys("1992-03-10");
		 }else {
			 radioButton.get(0).click();
		 }
	    
	    // for checkboxes
	    getOther().click();
	    getDescribe().sendKeys("Whatsapp");
	    
	    // for selecting terms
	    boolean terms =getTerms().isSelected();
	    if (terms == false)
	    	getTerms().click();
	    
	    Thread.sleep(5000);
	    getContinue().click();
	    
	    Thread.sleep(5000);
	   
	}

}
