package com.de.application.thekeyproxyservice.common.util.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reply {
    @JsonProperty("embeddable")
    public boolean getEmbeddable() {
        return this.embeddable;
    }

    public void setEmbeddable(boolean embeddable) {
        this.embeddable = embeddable;
    }

    boolean embeddable;

    @JsonProperty("href")
    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    String href;
}
