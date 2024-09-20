package core;

import static utility.Report.generateReport;
import static utility.Report.report;
import static utility.Report.test;
import static utility.TakeScreenShot.takeScreenShot;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Page 
{
	public static WebDriver driver = null;
	
	public void beforeTest(String browser,String url,String reportname,String testname) throws Exception 
	  {
		
			// initialize report..
			generateReport(reportname,testname);
			
			// openbrowser
			if(browser.equals("chrome"))
			{
				System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,");
				driver = new ChromeDriver();
				
			}
			else if(browser.equals("edge"))
			{
				driver = new EdgeDriver();
			}
			else if(browser.equals("firefox"))
			{
				driver = new FirefoxDriver();
			}
			driver.get(url);
			
			PageFactory.initElements(driver, this); // compolsry to add for external xpath
			
			// comment in report..
			test.log(Status.PASS, MarkupHelper.createLabel("Browser "+browser+" url "+url+" opens ",ExtentColor.GREEN));
			
			// screen shot
			takeScreenShot("OpenBrowser");
			
			// implicit wait.. one time standard time out for all elements
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			driver.manage().window().maximize();
		
	  }

	 
	  public static void afterTest() 
	  {
		  // close browser
		  driver.quit();
		  
		  // close report
		  report.flush();
	  }

	

}
