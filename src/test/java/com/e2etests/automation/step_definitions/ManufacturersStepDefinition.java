package com.e2etests.automation.step_definitions;

import java.time.Duration;

import com.e2etests.automation.page_objects.ManufacturersPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManufacturersStepDefinition {
	public ConfigFileReader configFileReader;
	public SeleniumUtils utils;
	public SelectFromListUtils select;
	public Validations validation;
	public ManufacturersPage manufacturersPage;
	public SelectFromListUtils selectUtils;
	public Wait wait;

	public ManufacturersStepDefinition() {

		configFileReader = new ConfigFileReader();
		utils = new SeleniumUtils();
		select = new SelectFromListUtils();
		validation = new Validations();
		manufacturersPage = new ManufacturersPage();
		selectUtils = new SelectFromListUtils();
		wait = new Wait(Setup.getDriver());
	}

	@When("User click on catalog menu")
	public void userClickOnCatalogMenu()  {
		utils.click(manufacturersPage.catalogue);

	}

	@When("click on Manufacturers")
	public void clickOnManufacturers() throws InterruptedException {
		Thread.sleep(3000);
	wait.forPresenceOfElement(Duration.ofSeconds(3000),ManufacturersPage.manufacturers,configFileReader.getProperties("Manufacturers"));

		utils.click(ManufacturersPage.manufacturers);

	}

	@When("Click on Add New button")
	public void clickOnAddNewButton() {
		utils.click(manufacturersPage.addNewBtn);

	}

	@Then("User can view {string}")
	public void userCanView(String AddManuf) {
		validation.assertTrue(manufacturersPage.newManuf, AddManuf);

	}

	@When("user enter Manufacturer info")
	public void userEnterManufacturerInfo() throws InterruptedException   {

		/*utils.writeText(manufacturersPage.name, configFileReader.getProperties("Name.manufacturer"));
		
Thread.sleep(3000);
		utils.writeText(manufacturersPage.description, configFileReader.getProperties("Description.manufacturer"));
*/
		utils.writeText(manufacturersPage.name, configFileReader.getProperties("Name.manufacturer"));
		wait.forElementToBeDisplayed(Duration.ofSeconds(20),manufacturersPage.iFrame,configFileReader.getProperties("iframeIdManif"));

		utils.switchToNewWindow(Setup.getDriver(), configFileReader.getProperties("iframeId"));
		utils.writeText(manufacturersPage.description, configFileReader.getProperties("Description.manufacturer"));
		utils.switchToDefaultFrame();
	
	}

	@When("Click on Save button")
	public void clickOnSaveButton() {

		utils.click(manufacturersPage.saveBtn);
	}

	@Then("User can view Manufacturer added confirmation message {string}")
	public void userCanViewManufacturerAddedConfirmationMessage(String msg) {
		validation.assertTrue(manufacturersPage.msgAddMaufact, msg);
	
	}
	

	@When("Enter Manufacturer Name")
	public void enterManufacturerName() {
		utils.writeText(manufacturersPage.SearchManufacturerName, configFileReader.getProperties("Name.manufacturer"));
	   
	}
	@When("Click on Manufacturer Search button")
	public void clickOnManufacturerSearchButton() {
		utils.click(manufacturersPage.searchBtn);
	 
	}
	@Then("User should found Manufacturer Name in the search table")
	public void userShouldFoundManufacturerNameInTheSearchTable() throws InterruptedException {
		Thread.sleep(3000);
		selectUtils.findElementByElementInTable(manufacturersPage.tableManuf,configFileReader.getProperties("Name.manufacturer"));
	    System.out.println("found");
	}





}
