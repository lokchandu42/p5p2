package com.qa.tests.se;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public abstract class BaseBeforeClass
{
    private static Logger logger;
    private static WebDriver webDriver;

    @BeforeClass
    public void setup()
    {
        logger = Logger.getLogger(BaseBeforeClass.class.getName());
        webDriver = new ChromeDriver();
    }

    public WebDriver getWebDriver()
    {
        return webDriver;
    }

    public Logger getLogger()
    {
        return logger;
    }

    @AfterClass
    public void tearDown()
    {
        webDriver.quit();
        if(webDriver.toString().toLowerCase().contains("null"))
            logger.info("\t-> web driver has successfully quit");
    }
}
