package com.SWC.tests;

import org.testng.Assert;

import com.SWC.pages.HomePage;
import com.SWC.pages.LoginPage;
import com.SWC.utilities.BaseFunctions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	BaseFunctions selenium;
	LoginPage lp;
	HomePage hp;
	
	
	@Given("^I go to SocialWareApp$")
	public void i_go_to_SocialWareApp(){
		selenium = new BaseFunctions();
		selenium.openApp("chrome");
	}

	@And("^I enter landing page \"([^\"]*)\"$")
	public void i_enter_landing_page(String input){
		lp = new LoginPage();
		lp.textField(input);
	}
	
	@And("^I write a post")
	public void i_write_a_post(){
		hp = new HomePage();
		hp.writePost();
	}
	
	@When("^I click landing page \"([^\"]*)\"$")
	public void i_click_landing_page(String input){
		lp = new LoginPage();
		lp.clickElement(input);
	}
	
	@Then("^I validate \"([^\"]*)\" text$")
	public void i_validate_text(String input){
		lp = new LoginPage();
		Assert.assertEquals(lp.validateText(input), true);
		selenium  = new BaseFunctions();
		selenium.closeApp();
	}
	
	@When("^I click home page \"([^\"]*)\"$")
	public void i_click_home_page(String input){
		hp = new HomePage();
		hp.clickElement(input);
	}
	
	@Then("^I validate the post is present$")
	public void i_validate_the_post_is_present(){
		hp = new HomePage();
		Assert.assertEquals(hp.validate(), true);
		selenium  = new BaseFunctions();
		selenium.closeApp();
	}
	
	@Then("^I validate the home page footer links$")
	public void i_validate_the_home_page_footer_links(){
		hp = new HomePage();
		Assert.assertEquals(hp.homeFooterLink(), true);
		selenium  = new BaseFunctions();
		selenium.closeApp();
	}

}
