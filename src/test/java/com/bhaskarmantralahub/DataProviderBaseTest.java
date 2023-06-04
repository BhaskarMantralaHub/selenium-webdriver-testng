package com.bhaskarmantralahub;

import org.testng.annotations.DataProvider;

public class DataProviderBaseTest {
    @DataProvider(name = "test-provider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Hey", "Bhaskar"}
        };
    }
}
