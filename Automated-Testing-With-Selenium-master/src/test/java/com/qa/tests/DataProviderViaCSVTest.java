package com.qa.tests;

import com.qa.dataProvider.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class DataProviderViaCSVTest
{
    @Test(dataProvider = "csv-data", dataProviderClass = DataProviderClass.class)
    public void dataFromCSVFileTest(Map<String, String> data)
    {
        System.out.println(data);
        Assert.assertTrue(data.size() == 3);
    }
}
