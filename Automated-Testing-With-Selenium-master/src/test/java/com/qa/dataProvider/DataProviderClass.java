package com.qa.dataProvider;

import com.qa.dataReader.DataReader;
import org.testng.annotations.DataProvider;

import java.io.File;

public class DataProviderClass
{
    private static final String file = (new File("."+"/src/test/java/com/qa/data/sampleData.csv").toString());

    @DataProvider(name = "csv-data")
    public static Object[][] readDataToMap()
    {
        return new Object[][] {{DataReader.csvDataReader(file)}};
    }
}
