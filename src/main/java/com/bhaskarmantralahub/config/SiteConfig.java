package com.bhaskarmantralahub.config;

import com.bhaskarmantralahub.enums.Env;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SiteConfig {
    private static String CONFIG_FILE;

    public SiteConfig(String yamlFile) {
        SiteConfig.CONFIG_FILE = yamlFile;
    }

    public SiteConfig() {
        SiteConfig.CONFIG_FILE = "site-config.yaml";
    }

    private HashMap<String, String> configMap = null;

    private void load() {
        System.out.println("File to read is " + CONFIG_FILE);
        InputStream inputStream = SiteConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        Yaml yaml = new Yaml();
        configMap = yaml.load(inputStream);
    }

    public HashMap<String, String> read() {
        load();
        System.out.println(configMap);
        return configMap;
    }

//    public static Object getProperty(String key) {
//        System.out.println(configMap.toString());
//        System.out.println(configMap.get(key));
//        return configMap.get(key);
//    }
}

