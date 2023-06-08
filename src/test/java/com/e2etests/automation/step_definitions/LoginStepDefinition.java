package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.LoginPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	public ConfigFileReader configFileReader;
	public SeleniumUtils utils;
	public SelectFromListUtils select;
	public Validations validation;
	public LoginPage loginPage;

	public LoginStepDefinition() {

		configFileReader = new ConfigFileReader();
		utils = new SeleniumUtils();
		select = new SelectFromListUtils();
		validation = new Validations();
		loginPage= new LoginPage();
	}

	@Given("I am on the login page")
	public void iAmOnTheLoginPage() {
		utils.get(configFileReader.getProperties("home.url"));
	}

	@When("I enter the email and password")
	public void iEnterTheEmailAndPassword() {
		utils.writeText(loginPage.email, configFileReader.getProperties("email"));
		utils.writeText(loginPage.password, configFileReader.getProperties("password"));


	}

	@When("I click the login button")
	public void iClickTheLoginButton() {
		utils.click(loginPage.btnLogin);

	}

	
	@Then("Page Title should be {string}")
	public void pageTitleShouldBe(String Dashboard) {
		validation.assertEquals(loginPage.dashboard, Dashboard);

	}

	@When("User click on Log out link")
	public void userClickOnLogOutLink() {
		utils.click(loginPage.btnLogout);

	}

	@Then("Title of the page should be {string}")
	public void titleOfThePageShouldBe(String title) {
		validation.checkChangedURL(title);
		

	}

	@When("I enter the email {string} and password {string}")
	public void iEnterTheEmailAndPassword(String email, String password) {
		utils.writeText(loginPage.email, email);
		utils.writeText(loginPage.password, password);


	}

	@Then("I should see an error message {string}")
	public void iShouldSeeAnErrorMessage(String msg) {
		validation.assertTrue(loginPage.errorMsg, msg);

	}

}
