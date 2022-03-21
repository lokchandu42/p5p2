package com.qa.tests.se;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseBeforeClass
{
    @Test
    public void navigationTest()
    {
        try
        {
            final String url = "https://github.com/";
            getWebDriver().navigate().to(url);
            Thread.sleep(2000);

            final String url2 = "https://github.com/HamidurRahman1";
            getWebDriver().navigate().to(url2);
            Thread.sleep(2000);

            getWebDriver().navigate().back();
            Thread.sleep(3000);

            getWebDriver().navigate().forward();
            Thread.sleep(3000);
            Assert.assertEquals(getWebDriver().getCurrentUrl(), url2);
        }
        catch (Exception e)
        {
            getLogger().severe("\t-> Error occurred: "+e.getMessage());
        }
    }
}
