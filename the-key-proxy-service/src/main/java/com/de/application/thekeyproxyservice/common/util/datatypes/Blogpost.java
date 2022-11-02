package com.de.application.thekeyproxyservice.common.util.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Blogpost {
    @JsonProperty("id")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer id;

    @JsonProperty("date")
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date date;

    @JsonProperty("date_gmt")
    public Date getDate_gmt() {
        return this.date_gmt;
    }

    public void setDate_gmt(Date date_gmt) {
        this.date_gmt = date_gmt;
    }

    public Date date_gmt;

    @JsonProperty("guid")
    public Guid getGuid() {
        return this.guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public Guid guid;

    @JsonProperty("modified")
    public Date getModified() {
        return this.modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date modified;

    @JsonProperty("modified_gmt")
    public Date getModified_gmt() {
        return this.modified_gmt;
    }

    public void setModified_gmt(Date modified_gmt) {
        this.modified_gmt = modified_gmt;
    }

    public Date modified_gmt;

    @JsonProperty("slug")
    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String slug;

    @JsonProperty("status")
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String status;

    @JsonProperty("type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String type;

    @JsonProperty("link")
    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String link;

    @JsonProperty("title")
    public Title getTitle() {
        return this.title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Title title;

    @JsonProperty("content")
    public Content getContent() {
        return this.content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Content content;

    @JsonProperty("excerpt")
    public Excerpt getExcerpt() {
        return this.excerpt;
    }

    public void setExcerpt(Excerpt excerpt) {
        this.excerpt = excerpt;
    }

    public Excerpt excerpt;

    @JsonProperty("author")
    public Integer getAuthor() {
        return this.author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer author;

    @JsonProperty("featured_media")
    public Integer getFeatured_media() {
        return this.featured_media;
    }

    public void setFeatured_media(Integer featured_media) {
        this.featured_media = featured_media;
    }

    public Integer featured_media;

    @JsonProperty("comment_status")
    public String getComment_status() {
        return this.comment_status;
    }

    public void setComment_status(String comment_status) {
        this.comment_status = comment_status;
    }

    public String comment_status;

    @JsonProperty("ping_status")
    public String getPing_status() {
        return this.ping_status;
    }

    public void setPing_status(String ping_status) {
        this.ping_status = ping_status;
    }

    public String ping_status;

    @JsonProperty("sticky")
    public boolean getSticky() {
        return this.sticky;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    public boolean sticky;

    @JsonProperty("template")
    public String getTemplate() {
        return this.template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String template;

    @JsonProperty("format")
    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String format;

    @JsonProperty("meta")
    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Meta meta;

    @JsonProperty("categories")
    public ArrayList<Integer> getCategories() {
        return this.categories;
    }

    public void setCategories(ArrayList<Integer> categories) {
        this.categories = categories;
    }

    public ArrayList<Integer> categories;

    @JsonProperty("tags")
    public ArrayList<Object> getTags() {
        return this.tags;
    }

    public void setTags(ArrayList<Object> tags) {
        this.tags = tags;
    }

    public ArrayList<Object> tags;

    @JsonProperty("_links")
    public Links get_links() {
        return this._links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    public Links _links;
}

