package com.de.application.thekeyproxyservice.common.util.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Excerpt {
    @JsonProperty("rendered")
    public String getRendered() {
        return this.rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    String rendered;

    @JsonProperty("protected")
    public boolean getMyprotected() {
        return this.myprotected;
    }

    public void setMyprotected(boolean myprotected) {
        this.myprotected = myprotected;
    }

    boolean myprotected;
}
