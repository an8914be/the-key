package com.de.application.thekeyproxyservice.common.util.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    @JsonProperty("_seopress_robots_primary_cat")
    public String get_seopress_robots_primary_cat() {
        return this._seopress_robots_primary_cat;
    }

    public void set_seopress_robots_primary_cat(String _seopress_robots_primary_cat) {
        this._seopress_robots_primary_cat = _seopress_robots_primary_cat;
    }

    String _seopress_robots_primary_cat;
}
