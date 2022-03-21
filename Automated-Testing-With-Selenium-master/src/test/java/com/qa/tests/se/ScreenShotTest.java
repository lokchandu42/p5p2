package com.qa.tests.se;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShotTest extends BaseBeforeClass
{
    @Test
    public void takeScreenShot()
    {
        try
        {
            getWebDriver().get("https://www.testandquiz.com/selenium/testing.html");
    
            Thread.sleep(2000);
            
            File file = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.FILE);
            System.out.println(file.getAbsolutePath());
    
            Path path = Files.move(Paths.get(file.getAbsolutePath()), Paths.get("/Users/hamidurrahman/Downloads/"+file.getName()));
    
            Assert.assertNotNull(path);
        }
        catch(Exception e)
        {
            getLogger().severe("\t-> Error occurred: "+e.getMessage());
        }
    }
}
