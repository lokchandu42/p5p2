package com.qa.tests.se;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownTest extends BaseBeforeClass
{
    @Test(priority = 0, enabled = true)
    public void dropDownTest()
    {
        try
        {
            final String expectedUrl = "https://www.testandquiz.com/selenium/testing.html";

            getWebDriver().get(expectedUrl);
            getWebDriver().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

            WebElement selectElement = getWebDriver().findElement(By.id("testingDropdown"));

            Select selectElementHolder = new Select(selectElement);
            System.out.println("Selected Options -> ");
            selectElementHolder.getAllSelectedOptions().forEach(e -> System.out.println(e.getText()));
            System.out.println("All Options -> ");
            selectElementHolder.getOptions().forEach(e -> System.out.println(e.getText()));

            String automationVisibleText = "Automation Testing";
            String dbValue = "Database";
            selectElementHolder.selectByValue(dbValue);

            Thread.sleep(2000);

            selectElementHolder.selectByIndex(1);

            Thread.sleep(2000);

            selectElementHolder.selectByVisibleText(automationVisibleText);

            Thread.sleep(2000);

            Assert.assertEquals(automationVisibleText, selectElementHolder.getFirstSelectedOption().getText());
        }
        catch(Exception e)
        {
            getLogger().severe("\t-> Error occurred: "+e.getMessage());
        }
    }
}
