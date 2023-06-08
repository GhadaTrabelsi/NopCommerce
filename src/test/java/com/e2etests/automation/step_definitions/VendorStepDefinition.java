package com.e2etests.automation.step_definitions;

import java.time.Duration;

import com.e2etests.automation.page_objects.VendorPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VendorStepDefinition {
	
	public ConfigFileReader configFileReader;
	public SeleniumUtils utils;
	public SelectFromListUtils select;
	public Validations validation;
	public VendorPage vendorPage;
	public SelectFromListUtils selectUtils;
	public Wait wait;

	public VendorStepDefinition() {

		configFileReader = new ConfigFileReader();
		utils = new SeleniumUtils();
		select = new SelectFromListUtils();
		validation = new Validations();
		vendorPage = new VendorPage();
		selectUtils = new SelectFromListUtils();
		wait = new Wait(Setup.getDriver());
	}
	
	
	@When("click on vendors Menu Item")
	public void clickOnVendorsMenuItem() {
		utils.waitForElementToBeClickable(VendorPage.vendorBtn);
		utils.click(VendorPage.vendorBtn);
		//System.out.println("clicked");
	 
	}
	
	@And("click on Add new vendor button")
	public void clickOnAddNewVendorButton() {
		utils.click(VendorPage.addNewBtn);

	}
	@Then("User can view Add new vendor page")
	public void userCanViewAddNewVendorPage()  {
		
		validation.isElementDisplayed(VendorPage.email);
		System.out.println("succ");

	}
	@When("User enter vendor info")
	public void userEnterVendorInfo() {

		utils.writeText(VendorPage.name, configFileReader.getProperties("vendor.name"));
		wait.forElementToBeDisplayed(Duration.ofSeconds(20),VendorPage.iFrame,configFileReader.getProperties("iframeId"));

		utils.switchToNewWindow(Setup.getDriver(), configFileReader.getProperties("iframeId"));
		utils.writeText(VendorPage.description, configFileReader.getProperties("vendor.description"));
		utils.switchToDefaultFrame();
	    utils.writeText(VendorPage.email, configFileReader.getProperties("vendor.email"));
	

	}
	@When("click on Save button for vendor")
	public void clickOnSaveButtonForVendor() {
		utils.click(VendorPage.saveBtn);
	    
	}
	@Then("User can view confirmation message for vendor {string}")
	public void userCanViewConfirmationMessageForVendor(String msg) {
		validation.assertTrue(VendorPage.message, msg);
		
	    
	}

	
	@When("Enter vendor Email")
	public void enterVendorEmail() throws InterruptedException {
		Thread.sleep(3000);
		utils.writeText(VendorPage.SearchEmail, configFileReader.getProperties("vendor.email"));
	 
	}
	@When("Click on search vendor button")
	public void clickOnSearchVendorButton() {
	  utils.click(VendorPage.searchBtn);
	}
	@Then("User should find Email of vendor in the search table")
	public void userShouldFindEmailOfVendorInTheSearchTable() throws InterruptedException {
		Thread.sleep(3000);
		selectUtils.findElementByElementInTable(VendorPage.vendorTable, configFileReader.getProperties("vendor.email"));
		//System.out.println("found");
	   
	}



	@When("Enter vendor Name")
	public void enterVendorName() throws InterruptedException {
		Thread.sleep(3000);
		utils.writeText(VendorPage.SearchName, configFileReader.getProperties("vendor.name"));
	   
	}
	@Then("User should find Name  of vendor in the search table")
	public void userShouldFindNameOfVendorInTheSearchTable() throws InterruptedException {
		Thread.sleep(3000);
		selectUtils.findElementByElementInTable(VendorPage.vendorTable, configFileReader.getProperties("vendor.name"));
		//System.out.println("found");
	}




	
	
	
	

}
