package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAndSoftAssertTest
{
    @Test
    public void hardAssertTest()
    {
        // hard asserts are just regular assert in TestNg. If any assert fails then the whole test fails. If any exceptions
        // are thrown and not handled then the whole program execution stops
        Assert.assertTrue(true);
        Assert.assertEquals(1, 1);
        Assert.assertTrue(true);
    }

    /*
        SoftAssert in TestNG helps to collect all the assertions throughout the @Test method.
        And to see assertions result at the end of the test, we have to invoke assertAll().
        SoftAssert don't throw an exception when an assert fails.
        The test execution will continue with the next step after the assert statement.

        Soft Asserts are used using SoftAssert class.
     */
}
