package com.de.application.thekeyproxyservice.common.util.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PredecessorVersion {
    @JsonProperty("id")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer id;

    @JsonProperty("href")
    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    String href;
}
