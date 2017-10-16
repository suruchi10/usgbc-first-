package com.usgbc.dev.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.usgbc.utility.Base;

public class UsgbcWebLocators extends Base{
	public static WebDriver driver;
	
	public UsgbcWebLocators (WebDriver driver) {
		UsgbcWebLocators.driver = driver;
	}
		
   /* web element locator for community_registration page*/
	 @FindBy(linkText="Community Registration")WebElement communityRegistration;
		public WebElement getcommunityRegistration() {
			return communityRegistration;
			}
	
    public static By Community_Name = By.id ("edit-community-name");
    public static WebElement getCommunity_Name() {
    	return driver.findElement(Community_Name);
    }
    
    public  static By Attention = By.id ("edit-attention-to");
    public  static WebElement getAttention() {
    	return driver.findElement(Attention);
    }
    
    public  static By Company = By.id ("edit-company");
    public  static WebElement getCompany() {
    	return driver.findElement(Company);
    }
    
    public  static By Country = By.name ("address[country_code]");
    public  static WebElement getCountry() {
    	return driver.findElement(Country);
    }
    
    public  static By Street_Address = By.xpath(".//*[@class='address-line1 form-text required']");
    public  static WebElement getStreet_Address() {
    	return driver.findElement(Street_Address);
    }
    public  static By Street_Address2 = By.xpath(".//*[@class='address-line2 form-text required']");
    public static WebElement getStreet_Address2() {
    	return driver.findElement(Street_Address2);
    }
    
    public  static By City = By.name("address[locality]");
    public  static WebElement getCity() {
    	return driver.findElement(City);
    }
    
    public static By Zip_code = By.xpath(".//*[@name='address[postal_code]']");
    public static WebElement getZip_code() {
    	return driver.findElement(Zip_code);
    }
   
    public static By State = By.xpath(".//*[@class='administrative-area form-select required']");
    public static WebElement getState() {
    	return driver.findElement(State);
    }
    
    public static By Is_student = By.name ("is_student");
    public static WebElement getIs_student() {
    	return driver.findElement(Is_student);
    }
    
    public static By Full_time_student_no = By.id ("edit-is-student-n");
    public static WebElement getFull_time_student_no() {
    	return driver.findElement(Full_time_student_no);
    }
    
    public static By Full_time_student_yes = By.id ("edit-is-student-y");
    public static WebElement getFull_time_student_yes() {
    	return driver.findElement(Full_time_student_yes);
    }
    
    public static By School = By.id ("edit-school");
    public static WebElement getSchool() {
    	return driver.findElement(School);
    }
    
    public static By Student_ID  = By.id ("edit-student-id");
    public static  WebElement getStudent_ID() {
    	return driver.findElement(Student_ID);
    }
    
    public static By Graduation  = By.id ("edit-graduation-date");
    public static WebElement getGraduation() {
    	return driver.findElement(Graduation);
    }
  
    public static By Emerging_Professional_no = By.id ("edit-is-emerging-prof-n");
    public static WebElement getEmerging_Professional_no() {
    	return driver.findElement(Emerging_Professional_no);
    }
    
    public static By Emerging_Professional_yes = By.id ("edit-is-emerging-prof-y");
    public static WebElement getEmerging_Professional_yes() {
    	return driver.findElement(Emerging_Professional_yes);
    }
    
    public static By Birthday = By.id ("edit-emerging-prof-bday");
    public static  WebElement getBirthday() {
    	return driver.findElement(Birthday);
    }
    
    public static By Terms = By.id ("edit-terms");
    public static WebElement getTerms() {
    	return driver.findElement(Terms);
    }
    
    public static By Other = By.id ("edit-how-did-you-hear-5");
    public static  WebElement getOther() {
    	return driver.findElement(Other);
    }
    
    public static By Describe = By.id ("edit-how-did-you-hear-text");
    public static WebElement getDescribe() {
    	return driver.findElement(Describe);
    }
    
    public static By Continue = By.id ("edit-submit");
    public static WebElement getContinue() {
    	return driver.findElement(Continue);
    }
    public static By Cancel = By.id ("edit-cancel");
    public static WebElement getCancel() {
    	return driver.findElement(Cancel);
    }
  /* web element locator for signup page */
    
    @FindBy(id="edit-first-name")WebElement firstname;
    @FindBy(id="edit-last-name")WebElement lastname;
    @FindBy(id="edit-email")WebElement email;
    @FindBy(id="edit-password")WebElement password;
    @FindBy(id="edit-confirm-password")WebElement confirm_password;
    @FindBy(id="edit-submit")WebElement register_continue;
    @FindBy(how=How.LINK_TEXT , using ="Sign in") WebElement signin;

    	public void signup_usgbc(String fname,String lname,String uemail,String upassword ,String cpassword) throws InterruptedException {
    		Thread.sleep(3000);
    		firstname.click();
    		firstname.sendKeys(fname);
    		lastname.sendKeys(lname);
    		email.sendKeys(uemail);
    		password.sendKeys(upassword);
    		confirm_password.sendKeys(cpassword);
    		register_continue.click();
    		
    	}
    	
   /* web element locator for signin page */
   @FindBy(id="edit-existinguser-usernamae")WebElement Eusername;
   @FindBy(id="edit-existinguser-password")WebElement Epassword;
   @FindBy(id="edit-submit")WebElement signin_continue;
   public By  register = By.linkText("Register Here.");
  	public WebElement getRegister() {
  			return driver.findElement(register);
  			}
  	@FindBy(xpath="html/body/div[1]/div/div/div/div/div/h2")WebElement status_message_signup;
  	public WebElement getstatusMessageSignup() {
			return status_message_signup;
			}
    	
   public void signin_usgbc(String Euname , String Epass) throws InterruptedException {
		
	    //Thread.sleep(3000);
	    Eusername.click();
	    Eusername.sendKeys(Euname);
		Epassword.sendKeys(Epass);
		signin_continue.click();
		//Thread.sleep(3000);
		  
	}	
   
   /* web element locator for payment page */
   
   @FindBy(id="edit-payment-type-card")WebElement credit_card;
   @FindBy( id="edit-payment-type-check")WebElement check;
   @FindBy(id="edit-name-on-card")WebElement name_on_card;
   @FindBy(id="edit-card-number")WebElement card_number;
   @FindBy(id="edit-cardexpiration-month")WebElement month;
   @FindBy(id="edit-cardexpiration-year")WebElement year;
   @FindBy(id="edit-security-code")WebElement security_code;
   @FindBy(xpath=".//*[@name='billing_address[country_code]']")WebElement billing_country;
   @FindBy(xpath=".//*[@class='address-line1 form-text required']")WebElement billing_street_address;
   @FindBy(xpath=" .//*[@class='address-line2 form-text required']")WebElement billing_street_address2;
   @FindBy(xpath=".//*[@class='locality form-text required']")WebElement billing_city;
   @FindBy(xpath=".//*[@class='postal-code form-text required']")WebElement billing_pin_code;
   @FindBy(xpath=".//*[@class='administrative-area form-select required']")WebElement billing_state;
   @FindBy(xpath=".//*[@id='edit-payment-submit']")WebElement submit_payment;

   
   public void payment_usgbc(String n_o_c , String c_n, String mon, String yea,String s_code,
		   String billing_coun,String billing_street_add,String billing_street_add2,String b_city,
		   String billing_pin_cod,String billing_stat )  {
		
	   try {
		   Thread.sleep(3000);
		  // billing_country.sendKeys(billing_coun);
		   Thread.sleep(5000);
		   name_on_card.sendKeys(n_o_c);
		   card_number.sendKeys(c_n); 
		   month.sendKeys(mon);
		   year.sendKeys(yea);
		   security_code.sendKeys(s_code);
		   Thread.sleep(5000);
		   Select select = new Select(billing_country);
	 	   select.selectByVisibleText(billing_coun);
	 	   Thread.sleep(3000);
		   billing_street_address.click();
		   billing_street_address.sendKeys(billing_street_add);
		   billing_street_address2.sendKeys(billing_street_add2);
		   billing_city.sendKeys( b_city);
		   billing_pin_code.sendKeys(billing_pin_cod);
		   billing_state.sendKeys(billing_stat);
		   submit_payment.click();
		   Thread.sleep(3000);
	     } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
   }
	 
	  /*web element locator for reciept page */
	  
	   public By  print_Receipt = By.xpath(".//*[@id='edit-submit-button-1-submit']");
	  	public WebElement getprint_Receipt() {
	  			return driver.findElement(print_Receipt);
	  			}
		
	  	/*web element locator for UsgbcCore */
	  	
	  	 public By UsgbcCore = By.linkText("USGBC Core");
	   	public WebElement getUsgbcCore() {
	   			return driver.findElement(UsgbcCore);
	   			}
   
	    public By Community_Registration = By.linkText("Community Registration");
	   	public WebElement getCommunityRegistration() {
	   			return driver.findElement(Community_Registration);
	   			}
	   	
	   
	    public By ErrorMsg = By.xpath(".//*[@Class='messages messages--error']//*[@class='visually-hidden']");
	   	public WebElement getErrorMsg() {
	   			return driver.findElement(ErrorMsg);
	   			}
	   	
	   	
	    public By WelcomeMsg = By.xpath(".//*[@id='usgbc-community-registration-form']/div[2]/div/div[2]/div/div/h3/b");
	   	public WebElement getWelcomeMsg() {
	   			return driver.findElement(WelcomeMsg);
	   			}
	   	
	   	
	    public By SignOutLink = By.linkText("Sign out");
	   	public WebElement getSignOutLink() {
	   			return driver.findElement(SignOutLink);
	   			}
	   	
	   	
	    /*Error message web locator for communtiy registration */ 
	   	            
	   	
	    @FindBy(id=".//*[@id='edit-address']/div[3]/div[2]")WebElement error_address_line1 ;
	    public WebElement getError_address_line1() {
   			return error_address_line1 ;
   			}
	    @FindBy(id=".//*[@id='edit-address']/div[4]/div[2]")WebElement error_address_line2 ;
	    public WebElement getError_address_line2 () {
   			return error_address_line2;
   			}
	    @FindBy(id=".//*[@id='edit-address-container4']/div[1]/div[2]")WebElement error_city;
	    public WebElement getError_city() {
   			return error_city;
   			}
	    @FindBy(id=".//*[@id='edit-address-container4']/div[2]/div[2]")WebElement error_state;
	    public WebElement getError_state() {
   			return error_state;
   			}
	    @FindBy(id=".//*[@id='edit-address-container4']/div[3]/div[2]")WebElement error_zipcode;
	    public WebElement getError_zipcode() {
   			return error_zipcode;
   			}
	    @FindBy(id=".//*[@id='usgbc_community_reached_div_id']/div[2]/div[2]")WebElement errror_hear_about_us ;
	    public WebElement getErrror_hear_about_us() {
   			return errror_hear_about_us;
   			}
	    @FindBy(id=".//*[@id='usgbc-terms-accept']/div[1]/div[2]")WebElement error_terms_condition;
	    public WebElement getError_terms_condition() {
   			return error_terms_condition;
   			}
	   	
	   /* Store module web locator */ 
	    
	    @FindBy(linkText="USGBC Store")WebElement usgbc_store;
	   	public WebElement getUsgbcStore() {
	   			return usgbc_store;
	   			}
	    
	    @FindBy(xpath="html/body/div[1]/div/div/div/div/pre")WebElement Status_message ;
	   	public WebElement getStatusMessage() {
	   			return Status_message;
	   			}
	    
	    @FindBy(linkText="Green Apple Lapel Pins")WebElement GreenAppleLapelPins;
	   	public WebElement getGreenAppleLapelPins() {
	   			return GreenAppleLapelPins;
	   			}
	   	
	   	
	   	@FindBy(id="edit-submit-30")WebElement Add_to_cart;
	   	public WebElement getAddToCart() {
	   			return Add_to_cart;
	   			}
	   	
	 	@FindBy(xpath="html/body/div[1]/div/div/div/div")WebElement status_message1;
	   	public WebElement getStatusMessage1() {
	   			return status_message1;
	   			}
	   	
	   	@FindBy(xpath="html/body/div[1]/div/div/div/div/strong")WebElement status_message2;
	   	public WebElement getStatusMessage2() {
	   			return status_message2;
	   			}
	   	
	 	@FindBy(xpath=".//*[@id='edit-actions']/div/a")WebElement checkoutButton;
	   	public WebElement getCheckOutButton() {
	   			return checkoutButton;
	   			}
	   	
	   	/* Store/contact  web locator */ 
	   	
	    @FindBy(id="edit-attention-to")WebElement Contact_attention_to ;						
		@FindBy(id="edit-company")WebElement Contact_Company;
	   	@FindBy(name="shipping_address[country_code]")WebElement shipping_country;
	 	@FindBy(xpath=".//*[@name='shipping_address[address_line1]']" )WebElement shipping_address;
	 	@FindBy(xpath=".//*[@name='shipping_address[address_line2]']" )WebElement shipping_address_line2;
		@FindBy(xpath=".//*[@name='shipping_address[locality]']" )WebElement Contact_City;
	 	@FindBy(xpath=".//*[@id='edit-how-did-you-hear-2']" )WebElement how_did_you_hear;
	 	@FindBy(xpath=".//*[@id='edit-submit']" )WebElement Contact_Continue;
	 	
	 	@FindBy(xpath="html/body/div[1]/div/div/div/div[2]/div" )WebElement status_message_usgbc_payment;
		public WebElement getstatusMessageUsgbcPayment() {
   			return status_message_usgbc_payment;
   			}
	 	
	 	public void contact_store(String attention,String company,String country,String s_address,String s_address_line2 ,String city) throws InterruptedException {
    		
	 		Thread.sleep(3000);
    		Contact_attention_to.sendKeys(attention);
    		Contact_Company.sendKeys(company);
    		shipping_country.click();	
    		Select select = new Select(shipping_country);
	 	    select.selectByVisibleText(country);
	 	    Thread.sleep(3000);
    		shipping_address.sendKeys(s_address);
    		shipping_address_line2.sendKeys(s_address_line2);
    		Contact_City.sendKeys(city);
    		how_did_you_hear.click();
    		Contact_Continue.click();
    		
    	}
    	
	   			
}
