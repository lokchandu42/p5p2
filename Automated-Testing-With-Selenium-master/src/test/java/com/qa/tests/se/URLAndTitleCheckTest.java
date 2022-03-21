package com.qa.tests.se;

import org.testng.Assert;
import org.testng.annotations.Test;

public class URLAndTitleCheckTest extends BaseBeforeClass
{
    @Test(priority = 0, enabled = true)
    public void urlAndTitleTest()
    {
        try
        {
            final String expectedUrl = "https://www.testandquiz.com/selenium/testing.html";
            final String expectedTitle = "Sample Test Page";

            getWebDriver().get(expectedUrl);

            Assert.assertTrue(getWebDriver().getCurrentUrl().equals(expectedUrl));
            getLogger().info("\t-> url check is done and passed");
            Assert.assertTrue(getWebDriver().getTitle().equals(expectedTitle));
            getLogger().info("\t-> title check is done and passed");
        }
        catch(Exception e)
        {
            getLogger().severe("\t-> Error occurred: "+e.getMessage());
        }
    }
}
