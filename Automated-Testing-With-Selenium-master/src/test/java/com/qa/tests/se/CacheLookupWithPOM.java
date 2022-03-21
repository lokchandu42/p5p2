package com.qa.tests.se;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/*
    @CacheLookup will cache the the element(s) whenever first found and every subsequent call to will return the
    cache version of it. Using this @ will save time finding element(s) by going through DOM. It is useful when with
    static element(s) in nature.
 */
public class CacheLookupWithPOM extends BaseBeforeClass
{
    @Test
    public void cacheLookupWithPOMTest()
    {
        try
        {
            getWebDriver().get("https://github.com/login");

            GitHubLoginPOM pageObject = PageFactory.initElements(getWebDriver(), GitHubLoginPOM.class);
            pageObject.getUsername().sendKeys("myGithubUsername");

            long withoutCacheStartTime = System.currentTimeMillis();
            for(int i = 1; i <= 1000; i ++)
                pageObject.getUsername().getText();

            System.out.println("Time taken in seconds Without cache: " + ((System.currentTimeMillis() - withoutCacheStartTime)/ 1000));

            pageObject.getPassword().sendKeys("Github#@pass");
            long withCacheStartTime = System.currentTimeMillis();
            for(int i = 1; i <= 1000; i ++)
                pageObject.getPassword().getText();

            System.out.println("Time taken in seconds With cache: " + ((System.currentTimeMillis() - withCacheStartTime)/ 1000));
        }
        catch(Exception e)
        {
            getLogger().severe("\t-> Error occurred: "+e.getMessage());
        }
    }
}
