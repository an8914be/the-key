package com.de.application.thekeyproxyservice.common.util.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cury {
    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @JsonProperty("href")
    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    String href;

    @JsonProperty("templated")
    public boolean getTemplated() {
        return this.templated;
    }

    public void setTemplated(boolean templated) {
        this.templated = templated;
    }

    boolean templated;
}
