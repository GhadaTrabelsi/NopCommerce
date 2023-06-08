package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class LoginPage {
	public ConfigFileReader configFileReader;
	public LoginPage loginPage;

	/* Retrieve Element */

	

     @FindBy(how = How.ID, using = "Email")
 	public  WebElement email ; 
     @FindBy(how = How.ID, using = "Password")
  	public  WebElement password ; 
     @FindBy(how = How.XPATH, using = "//button[@type='submit']")
   	public  WebElement btnLogin ; 
     @FindBy(how = How.XPATH, using = "//h1[normalize-space()='Dashboard']")
    	public  WebElement dashboard ; 
     @FindBy(how = How.XPATH, using = "//a[normalize-space()='Logout']")
 	public  WebElement btnLogout ; 
     @FindBy(how = How.XPATH, using = "//div[@class='message-error validation-summary-errors']")
  	public  WebElement errorMsg ; 
	public LoginPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
	

}
