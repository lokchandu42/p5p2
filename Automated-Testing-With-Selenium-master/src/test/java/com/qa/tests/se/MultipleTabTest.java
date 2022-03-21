package com.qa.tests.se;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MultipleTabTest extends BaseBeforeClass
{
    @Test(priority = 0, enabled = true)
    public void dropDownTest()
    {
        try
        {
            final String url = "https://www.testandquiz.com/selenium/testing.html";

            getWebDriver().get(url);

            Thread.sleep(1000);
            Assert.assertEquals(url, getWebDriver().getCurrentUrl());

            String mainWindow = getWebDriver().getWindowHandle();
            getLogger().info("\t-> the main window: " + mainWindow);

            for (int i = 1; i <= 2; i++)
            {
                JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
                js.executeScript("window.open();");

                List<String> tabs = getWebDriver().getWindowHandles().stream().collect(Collectors.toList());
                final String lastOpenTab = tabs.get(tabs.size()-1);

                getWebDriver().switchTo().window(lastOpenTab);
                getWebDriver().get(url);

                Assert.assertEquals(url, getWebDriver().getCurrentUrl());
                Thread.sleep(2000);
            }

            Set<String> allTabs = getWebDriver().getWindowHandles();
            getLogger().info("\t-> total windows: " + allTabs.size());

            Thread.sleep(3000);

            allTabs.forEach(e -> {
                if(!e.equalsIgnoreCase(mainWindow))
                {
                    try
                    {
                        getWebDriver().switchTo().window(e);
                        Thread.sleep(2000);
                        getWebDriver().close();
                    }
                    catch (InterruptedException ex)
                    {
                        getLogger().severe("\t-> Error occurred: "+ex.getMessage());
                    }
                }
            });

            getWebDriver().switchTo().window(mainWindow);

            Thread.sleep(2000);
            getLogger().info("\t-> the main window: "+getWebDriver().getWindowHandle());

            Assert.assertEquals(mainWindow, getWebDriver().getWindowHandle());
            Thread.sleep(2000);
        }
        catch(Exception e)
        {
            getLogger().severe("\t-> Error occurred: "+e.getMessage());
        }
    }
}
