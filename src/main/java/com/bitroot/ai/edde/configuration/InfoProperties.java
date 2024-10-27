package com.bitroot.ai.edde.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "info")
public class InfoProperties {

    private String version;
    private String name;
    private String deployed;
    private String time;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeployed() {
        return deployed;
    }

    public void setDeployed(String deployed) {
        this.deployed = deployed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
