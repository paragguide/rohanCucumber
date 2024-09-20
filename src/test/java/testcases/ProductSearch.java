package testcases;

import static core.Hook.productsearchbox;
import static core.Hook.searchresults;
import static core.Page.driver;
import static utility.Report.report;
import static utility.Report.test;
import static utility.TakeScreenShot.takeScreenShot;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearch 
{
	public boolean x = false;
	
	@Given("you are logged in")
	public void you_are_logged_in() 
	{
	    if(UserTest.login == true)
	    {
	    	x = true;
	    }
	}
	@When("^you search for product (.*) in rage (.*)")
	public void you_search_for_product_in_rage(String productname,Integer price) throws Exception 
	{
	    if(x == true)
	    {
	    	test = report.createTest("search test");
	  	  
	  	  productsearchbox.clear();
	  	  productsearchbox.sendKeys(productname);
	  	  
	  	  test.log(Status.PASS, MarkupHelper.createLabel("searching -- "+productname, ExtentColor.GREEN));
	  	  
	  	  Actions a = new Actions(driver);
	  	  a.sendKeys(Keys.ENTER).perform();
	  	  
	  	  // screen shot
	  	  takeScreenShot("ProductResult-"+productname);
	  	  
	  	  int prodlist = searchresults.size();
	  	  if(prodlist < 0)
	  	  {
	  		  Assert.fail("No Products found..");
	  		  test.log(Status.FAIL, MarkupHelper.createLabel("searching -- "+productname+"Not Found", ExtentColor.RED));
	  		  
	  	  }
	  	  else
	  	  {
	  		  test.log(Status.PASS, MarkupHelper.createLabel("searching -- "+productname+" Found", ExtentColor.GREEN));
	  		  
	  	  }
	    }
	}
	@Then("results must come")
	public void results_must_come() 
	{
	    
	}

}
