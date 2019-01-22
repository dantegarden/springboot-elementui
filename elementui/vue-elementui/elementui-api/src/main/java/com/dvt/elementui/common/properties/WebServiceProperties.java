package com.dvt.elementui.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("webservices")
public class WebServiceProperties {

    private List<Map<String, String>> config;

    public List<Map<String, String>> getConfig() {
        return this.config;
    }

    public void setConfig(List<Map<String, String>> config) {
        this.config = config;
    }
}
