package testcases;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Forget extends Hook
{
	@Given("i open website {string} on browser {string} with reportname {string} and testname {string}")
	public void i_open_website_on_browser_with_reportname_and_testname(String url, String browser, String report, String test) throws Exception 
	{
		beforeTest(browser,url,report,test);
	}
	@Given("i click on sigin link on home page")
	public void i_click_on_sigin_link_on_home_page() 
	{
	    signin.click();
	}
	@When("i click help link and forget link")
	public void i_click_help_link_and_forget_link() 
	{
	    help.click();
	    forgetlink.click();
	}
	@When("enter mobile number")
	public void enter_mobile_number() 
	{
	    uid.sendKeys("9999999999");
	}
	@Then("send OTP")
	public void send_otp() 
	{
	    
	}



}
