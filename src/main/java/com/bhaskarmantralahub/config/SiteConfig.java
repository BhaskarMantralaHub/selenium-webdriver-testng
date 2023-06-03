package com.bhaskarmantralahub.config;

import com.bhaskarmantralahub.enums.Env;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class SiteConfig {
    private static final String CONFIG_FILE = System.getProperty("configFile", "site-config.yaml");

    private static final Map<Env, EnvConfig> configMap;

    static {
        System.out.println("Inside static block");
        InputStream inputStream = SiteConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        Yaml yaml = new Yaml();
        configMap = yaml.load(inputStream);
    }

    public static EnvConfig read() {
        System.out.println(configMap);
        return configMap.get(Env.DEV);
    }

//    public static Object getProperty(String key) {
//        System.out.println(configMap.toString());
//        System.out.println(configMap.get(key));
//        return configMap.get(key);
//    }
}

