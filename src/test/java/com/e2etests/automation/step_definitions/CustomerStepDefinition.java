package com.e2etests.automation.step_definitions;



import java.time.Duration;

import com.e2etests.automation.page_objects.CustomerPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.RandomValue;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerStepDefinition {

	public ConfigFileReader configFileReader;
	public SeleniumUtils utils;
	public SelectFromListUtils select;
	public Validations validation;
	public CustomerPage customerPage;
	public SelectFromListUtils selectUtils;
	public Wait wait;
	public RandomValue randomValue;

	public CustomerStepDefinition() {

		configFileReader = new ConfigFileReader();
		utils = new SeleniumUtils();
		select = new SelectFromListUtils();
		validation = new Validations();
		customerPage = new CustomerPage();
		selectUtils = new SelectFromListUtils();
		wait = new Wait(Setup.getDriver());
		randomValue = new RandomValue();
		
	}

	@When("User click on customers Menu")
	public void userClickOnCustomersMenu()   {

		utils.click(customerPage.customerMenu);

	}

	@When("click on customers Menu Item")
	public void clickOnCustomersMenuItem()  {
       wait.forPresenceOfElement(Duration.ofSeconds(2000),CustomerPage.customerItem,"customerItem");
		utils.click(CustomerPage.customerItem);

		//utils.waitForElementToBeClickable(CustomerPage.customerItem);

	}

	@When("click on Add new button")
	public void clickOnAddNewButton() {
		utils.click(customerPage.customerAdd);

	}

	@Then("User can view Add new customer page")
	public void userCanViewAddNewCustomerPage() {

		validation.isElementDisplayed(customerPage.email);
	}

	@When("User enter customer info")
	public void userEnterCustomerInfo() throws InterruptedException {
		//utils.writeText(customerPage.email, configFileReader.getProperties("email.customer"));
		utils.writeText(customerPage.email,RandomValue.getSaltString()+configFileReader.getProperties("email.customer"));
		utils.writeText(customerPage.Password, configFileReader.getProperties("password.customer"));
		utils.writeText(customerPage.FirstName, configFileReader.getProperties("firstName.customer"));
		utils.writeText(customerPage.LastName, configFileReader.getProperties("lastName.customer"));
		utils.click(customerPage.Gender_Female);
		utils.writeText(customerPage.DateOfBirth, configFileReader.getProperties("dateOfBirth.customer"));
		utils.writeText(customerPage.Company, configFileReader.getProperties("companyName.customer"));
		utils.click(customerPage.IsTaxExempt);
		utils.autoSuggest(customerPage.newsLetter, configFileReader.getProperties("newsletter.customer"),
				configFileReader.getProperties("newsletterSuggest.customer"));
		utils.autoSuggest(customerPage.customerRoles, configFileReader.getProperties("cutomerRoles.customer"),
				configFileReader.getProperties("cutomerRoles.customer"));
		selectUtils.selectDropDownListByVisibleText(customerPage.managerOfVender,
				configFileReader.getProperties("manageOfVendor.customer"));
		utils.writeText(customerPage.DateOfBirth, configFileReader.getProperties("dateOfBirth.customer"));
		utils.writeText(customerPage.DateOfBirth, configFileReader.getProperties("dateOfBirth.customer"));
		utils.writeText(customerPage.AdminComment, configFileReader.getProperties("adminComment.customer"));

	}

	@When("click on Save button")
	public void clickOnSaveButton() {
		utils.click(customerPage.saveBtn);
	}

	@Then("User can view confirmation message {string}")
	public void userCanViewConfirmationMessage(String confirmMsg) {
		validation.assertTrue(customerPage.newCustomer, confirmMsg);

	}

	@When("Enter customer Email")
	public void enterCustomerEmail() {
		utils.writeText(customerPage.SearchEmail, configFileReader.getProperties("email.customer"));

	}

	@When("Click on search button")
	public void clickOnSearchButton() {
		utils.click(customerPage.searchBtn);

	}

	@Then("User should find Email in the search table")
	public void userShouldFindEmailInTheSearchTable() throws InterruptedException {
		Thread.sleep(2000);
		selectUtils.findElementByElementInTable(customerPage.tableCustomer,configFileReader.getProperties("email.customer"));
		//wait.forPresenceOfElement(Duration.ofSeconds(3000), selectUtils.findElementByElementInTable(customerPage.tableCustomer,configFileReader.getProperties("email.customer")), configFileReader.getProperties("email.customer"));
		// System.out.println("found");
	}

	@When("Enter customer FirstName")
	public void enterCustomerFirstName() {
		utils.writeText(customerPage.SearchFirstName, configFileReader.getProperties("firstName.customer"));

	}

	@When("Enter customer LastName")
	public void enterCustomerLastName() {
		utils.writeText(customerPage.SearchLastName, configFileReader.getProperties("lastName.customer"));

	}

	@Then("User should find Name in the search table")
	public void userShouldFindNameInTheSearchTable() throws InterruptedException {
		Thread.sleep(2000);

		String fullName = configFileReader.getProperties("firstName.customer") + " "
				+ configFileReader.getProperties("lastName.customer");
		selectUtils.findElementByElementInTable(customerPage.tableCustomer, fullName);
		// System.out.println("found");
	}

}
