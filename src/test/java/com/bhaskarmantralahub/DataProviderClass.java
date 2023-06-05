package com.bhaskarmantralahub;

import com.bhaskarmantralahub.config.SiteConfig;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class DataProviderClass {
    @DataProvider(name = "test-provider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Hey", "Bhaskar"}
        };
    }

    @DataProvider(name = "test-provider-yaml")
    public Object[][] dataProviderFromYaml() {
        HashMap<String, String> envConfig = new SiteConfig("data-provider.yaml").read();
        return new Object[][]{
                envConfig.values().toArray()
        };
    }
}
