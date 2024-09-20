package testcases;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static utility.Report.*;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class UserTest extends Hook
{
	public static boolean userid = false;
	public boolean x = false;
	public static boolean login = false;
	  
	  // userid validation..
	
	@Given("I open browser {string} with url {string} and reportname {string} testname {string}")
	public void i_open_browser_with_url_and_reportname_testname(String browser, String url, String reportname, String testname) throws Exception 
	{
		beforeTest(browser,url,reportname,testname);
		test = report.createTest("UserTest");
		
	}
	
	@Given("click signin button")
	public void click_signin_button() 
	{
	    signin.click();
	}
	@When("I enter valid userid {string}")
	public void i_enter_valid_userid(String username) 
	{
	   uid.sendKeys(username);
	}
	@When("click continue button")
	public void click_continue_button() 
	{
	    ctnbtn.click();
	}
	@Then("error message should not come")
	public void error_message_should_not_come() 
	{
	    try {
	    	err1.getText();
	    	test.log(Status.FAIL, MarkupHelper.createLabel("userid is valid but error comes", ExtentColor.RED));
	    Assert.fail("userid is valid but error comes");
	    }
	    catch(Exception e)
	    {
	    	test.log(Status.PASS, MarkupHelper.createLabel("userid is valid", ExtentColor.GREEN));
	    	userid = true;
	    }
	}
        // password validation..
	@Given("userid is valid")
	public void userid_is_valid() 
	{
	   if(userid == true)
	   {
		   x = true;
	   }
	   else
	   {
		   x = false;
	   }
	}
	@When("i enter valid password {string}")
	public void i_enter_valid_password(String pas) 
	{
	    if(x == true)
	    {
	    	pwd.sendKeys(pas);
	    }
	}
	@When("click submit")
	public void click_submit() 
	{
	    submit.click();
	}
	@Then("i should login")
	public void i_should_login() 
	{
	    try
	    {
	    	err2.getText();
	    	test.log(Status.FAIL, MarkupHelper.createLabel("pwd is valid but shows error", ExtentColor.RED));
	    }
	    catch(Exception e)
	    {
	    	test.log(Status.PASS, MarkupHelper.createLabel("userid is valid", ExtentColor.GREEN));
	    	login = true;
	    }
	   
	}

     @When("close browser end test")
     public void close_browser_end_test()
     {
    	 afterTest() ;
     }
     


}
