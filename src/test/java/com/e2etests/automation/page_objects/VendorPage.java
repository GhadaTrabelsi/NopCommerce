package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class VendorPage {
	public ConfigFileReader configFileReader;
	public VendorPage vendorPage;

	/* Retrieve Element */

	
	@FindBy(how = How.XPATH, using = "//a[@href='/Admin/Vendor/List']")
	public static WebElement vendorBtn ;

     @FindBy(how = How.XPATH, using ="//a[@class='btn btn-primary']")
   	public static WebElement addNewBtn ; 
     @FindBy(how = How.ID, using = "Name")
 	public static WebElement name ;
     @FindBy(how = How.ID, using ="Description_ifr")
 	public static WebElement iFrame; 
     @FindBy(how = How.ID, using = "tinymce")
 	public static WebElement description  ;
     @FindBy(how = How.ID, using ="Email")
    	public static WebElement email ; 
     @FindBy(how = How.XPATH, using ="//button[@name='save']")
    	public static WebElement saveBtn ; 
    @FindBy(how = How.XPATH, using ="//div[@class='alert alert-danger alert-dismissable']" )
   	public static WebElement message ; 

	@FindBy(how = How.XPATH, using = "//a[@href='#']//p[contains(text(),'Customers')]")
	public static  WebElement customerMenu;
	 @FindBy(how = How.ID, using ="SearchEmail")
 	public static WebElement SearchEmail ;
	 @FindBy(how = How.ID, using ="search-vendors")
	 	public static WebElement  searchBtn ;
	 @FindBy(how = How.ID, using ="vendors-grid")
	 	public static WebElement  vendorTable ;
	 @FindBy(how = How.ID, using ="SearchName")
	 	public static WebElement SearchName ;
	 
	
	
   
  
  
     
     
     
     public VendorPage() {
  		PageFactory.initElements(Setup.getDriver(), this);
  	}
}
