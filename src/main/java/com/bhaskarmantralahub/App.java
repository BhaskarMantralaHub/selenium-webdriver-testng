package com.bhaskarmantralahub;

import com.bhaskarmantralahub.config.EnvConfig;
import com.bhaskarmantralahub.config.SiteConfig;

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

        EnvConfig envConfig = SiteConfig.read();
        System.out.println(envConfig);
    }
}
