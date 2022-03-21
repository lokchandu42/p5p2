package com.qa.tests.se;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseBeforeClass
{
    @Test
    public void dragAndDropTest()
    {
        try
        {
            final String url = "https://www.testandquiz.com/selenium/testing.html";

            getWebDriver().get(url);

            WebElement from = getWebDriver().findElement(By.id("sourceImage"));
            WebElement to = getWebDriver().findElement(By.id("targetDiv"));

            new Actions(getWebDriver()).dragAndDrop(from, to).build().perform();

            Thread.sleep(5000);
        }
        catch(Exception e)
        {
            getLogger().severe("\t-> Error occurred: "+e.getMessage());
        }
    }
}
