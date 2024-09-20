package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.Page;

public class TakeScreenShot extends Page
{
    public static void takeScreenShot(String scrname) throws Exception
    {
    	String targetpath = System.getProperty("user.dir")+"//src//test//java//screenshot//"+scrname+".jpg";
    
    	TakesScreenshot ts = (TakesScreenshot)driver;
       File temppath = ts.getScreenshotAs(OutputType.FILE); // stores screen shot in tmp location
       
       FileUtils.copyFile(temppath, new File(targetpath));
       
       
    }
}
