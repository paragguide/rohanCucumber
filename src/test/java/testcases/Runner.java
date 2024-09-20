package testcases;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\feature\\document.feature",
		tags = "(@amazon or @data2 or @close) and not (@data1)",
		//tags = "@forget or @close",
		glue = {"testcases"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty",
					"junit:src/test/java/reports/report.xml",
					"json:src/test/java/reports/report.json",
					"html:src/test/java/reports/report.html"
					},
		publish = true   
		        )
public class Runner 
{
	// empty
}
