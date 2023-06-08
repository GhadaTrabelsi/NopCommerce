package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class ManufacturersPage {
	public ConfigFileReader configFileReader;
	public ManufacturersPage manufacturersPage;

	/* Retrieve Element */

	

	
	@FindBy(how = How.XPATH, using = "//p[normalize-space()='Catalog']")
	public  WebElement catalogue;


     @FindBy(how = How.XPATH, using ="//p[text()=' Manufacturers']" )
  	public static  WebElement manufacturers ; 
     @FindBy(how = How.XPATH, using ="//a[@class='btn btn-primary']" )
   	public  WebElement addNewBtn ; 
     @FindBy(how = How.XPATH, using ="//h1[@class='float-left']" )
    	public  WebElement newManuf ; 
     @FindBy(how = How.ID, using ="Name" )
 	public  WebElement name ; 
     
     @FindBy(how = How.ID, using =("Description_ifr"))
   	public  WebElement iFrame ;
     @FindBy(how = How.ID, using =("tinymce"))
  	public  WebElement description ; 
   
     @FindBy(how = How.XPATH, using =" //button[@name='save']" )
   	public  WebElement saveBtn ; 
     @FindBy(how = How.XPATH, using =" //div[@class='alert alert-success alert-dismissable']" )
    	public  WebElement msgAddMaufact ; 
     @FindBy(how = How.ID, using ="SearchManufacturerName" )
  	public  WebElement SearchManufacturerName ; 
     @FindBy(how = How.ID, using ="search-manufacturers" )
   	public  WebElement  searchBtn ;
   
     @FindBy(how = How.XPATH, using ="//table[@id='manufacturers-grid']" )
    	public  WebElement  tableManuf ;
    
     public ManufacturersPage() {
 		PageFactory.initElements(Setup.getDriver(), this);
 	}
}
