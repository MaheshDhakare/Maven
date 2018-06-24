package TestFolder;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestcode {

	
	@Given("^A user is on xyz.com page$")
	public void a_user_is_on_xyz_com_page()  {

		System.out.println("Use is on xyz.com  page");	    
	}

	@When("^User clicks on My account link$")
	public void user_clicks_on_My_account_link()  {

		System.out.println("User clicked on My account");
	}

	@And("^User enters correct username and password$")
	public void user_enters_correct_username_and_password()  {

		System.out.println("User enters correct username and password ");
	}

	@Then("^User is able to successfully login$")
	public void user_is_able_to_successfully_login()  {

		System.out.println("User is able to successfully login");
	}
	
	
}
