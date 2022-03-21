package com.qa.tests.se;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
    To test out the @CacheLookup, I will use github login pages login field.
    username will NOT be cached but password will be cached.
 */
public class GitHubLoginPOM
{
    @FindBy(how = How.ID, using = "login_field")
    private WebElement username;

    @CacheLookup
    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }
}
