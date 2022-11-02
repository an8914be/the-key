package com.de.application.thekeyproxyservice.common.util.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Guid {
    @JsonProperty("rendered")
    public String getRendered() {
        return this.rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    String rendered;
}
