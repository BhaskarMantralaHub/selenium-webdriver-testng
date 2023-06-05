package com.bhaskarmantralahub;

import com.bhaskarmantralahub.config.AppConfig;
import com.bhaskarmantralahub.config.EnvConfig;
import com.bhaskarmantralahub.config.SiteConfig;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ParentClass parentClass = new ParentClass();
//        System.out.println(parentClass.whoAreYou());

        HashMap<String, String> envConfig = new SiteConfig("data-provider.yaml").read();
        System.out.println(envConfig);
    }
}
