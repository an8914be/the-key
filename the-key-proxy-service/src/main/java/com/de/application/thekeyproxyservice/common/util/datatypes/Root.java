package com.de.application.thekeyproxyservice.common.util.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    @JsonProperty("Blogpost")
    public Blogpost getBlogpost() {
        return this.blogpost;
    }

    public void setBlogpost(Blogpost blogpost) {
        this.blogpost = blogpost;
    }

    Blogpost blogpost;
}
