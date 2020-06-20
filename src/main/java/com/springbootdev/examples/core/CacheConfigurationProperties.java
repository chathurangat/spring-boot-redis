package com.springbootdev.examples.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "cache")
@Data
public class CacheConfigurationProperties {

    private long defaultTimeout = 15;
    private int redisPort = 6379;
    private String redisHost = "localhost";
    private Map<String, Long> cacheSettings = new HashMap<>();
}