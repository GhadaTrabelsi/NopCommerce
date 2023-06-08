package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class CustomerPage {
	
	public ConfigFileReader configFileReader;
	public CustomerPage customerPage;

	/* Retrieve Element */

	

	
	@FindBy(how = How.XPATH, using = "//a[@href='#']//p[contains(text(),'Customers')]")
	public  WebElement customerMenu;


     @FindBy(how = How.XPATH, using ="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
  	public static  WebElement customerItem ; 
     @FindBy(how = How.XPATH, using ="//a[@class='btn btn-primary']")
   	public  WebElement customerAdd ; 
     @FindBy(how = How.ID, using ="Email" )
    	public  WebElement email ; 
     
     @FindBy(how = How.ID, using ="Password" )
 	public  WebElement Password ;
     @FindBy(how = How.ID, using ="FirstName" )
 	public  WebElement FirstName ;
     @FindBy(how = How.ID, using ="LastName" )
 	public  WebElement LastName ;
     @FindBy(how = How.ID, using ="Gender_Male" )
 	public  WebElement Gender_Male ;
     @FindBy(how = How.ID, using ="Gender_Female" )
 	public  WebElement Gender_Female ;
     @FindBy(how = How.ID, using ="DateOfBirth" )
 	public  WebElement DateOfBirth ;
     @FindBy(how = How.ID, using ="Company" )
  	public  WebElement Company ;
     @FindBy(how = How.ID, using ="IsTaxExempt" )
  	public  WebElement IsTaxExempt ;
     @FindBy(how = How.XPATH, using ="//div[@class='input-group-append']//input[@role='listbox']" )
  	public  WebElement newsLetter  ;
     @FindBy(how = How.XPATH, using ="//div[@class='input-group-append input-group-required']//input[@role='listbox']" )
  	public  WebElement customerRoles  ;
     @FindBy(how = How.ID, using ="VendorId" )
   	public  WebElement managerOfVender   ;
    
     @FindBy(how = How.ID, using ="AdminComment")
   	public  WebElement AdminComment   ;
    
     @FindBy(how = How.XPATH, using ="//button[@name='save']" )
   	public  WebElement saveBtn   ;
     @FindBy(how = How.XPATH, using ="//div[@class='alert alert-success alert-dismissable']")
    	public  WebElement newCustomer ; 
     @FindBy(how = How.ID, using ="search-customers")
 	public  WebElement searchBtn ; 
     @FindBy(how = How.ID, using ="customers-grid_wrapper")
  	public  WebElement tableCustomer ; 
     @FindBy(how = How.ID, using ="SearchEmail")
   	public  WebElement SearchEmail ; 
     @FindBy(how = How.ID, using ="SearchFirstName")
    	public  WebElement SearchFirstName ;
     @FindBy(how = How.ID, using ="SearchLastName")
 	public  WebElement SearchLastName ;
     
     
   
	public CustomerPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
	

}



