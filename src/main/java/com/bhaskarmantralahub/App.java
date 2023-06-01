package com.bhaskarmantralahub;

import com.bhaskarmantralahub.config.SiteConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(SiteConfig.getProperty("url"));
        System.out.println(SiteConfig.getProperty("url"));
    }
}
