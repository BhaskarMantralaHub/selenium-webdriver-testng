package com.bhaskarmantralahub.config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class SiteConfig {
    private static final String CONFIG_FILE = System.getProperty("configFile", "dev.yaml");

    private static final Map<String, Object> configMap;

    static {
        System.out.println("Inside static block");
        InputStream inputStream = SiteConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        Yaml yaml = new Yaml();
        configMap = yaml.load(inputStream);
    }

    public static Object getProperty(String key) {
        return configMap.get(key);
    }
}

