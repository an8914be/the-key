package com.de.application.thekeyproxyservice.common.util.datatypes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Links {
    @JsonProperty("self")
    public ArrayList<Self> getSelf() {
        return this.self;
    }

    public void setSelf(ArrayList<Self> self) {
        this.self = self;
    }

    ArrayList<Self> self;

    @JsonProperty("collection")
    public ArrayList<Collection> getCollection() {
        return this.collection;
    }

    public void setCollection(ArrayList<Collection> collection) {
        this.collection = collection;
    }

    ArrayList<Collection> collection;

    @JsonProperty("about")
    public ArrayList<About> getAbout() {
        return this.about;
    }

    public void setAbout(ArrayList<About> about) {
        this.about = about;
    }

    ArrayList<About> about;

    @JsonProperty("author")
    public ArrayList<Author> getAuthor() {
        return this.author;
    }

    public void setAuthor(ArrayList<Author> author) {
        this.author = author;
    }

    ArrayList<Author> author;

    @JsonProperty("replies")
    public ArrayList<Reply> getReplies() {
        return this.replies;
    }

    public void setReplies(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    ArrayList<Reply> replies;

    @JsonProperty("version-history")
    public ArrayList<VersionHistory> getVersionHistory() {
        return this.versionHistory;
    }

    public void setVersionHistory(ArrayList<VersionHistory> versionHistory) {
        this.versionHistory = versionHistory;
    }

    ArrayList<VersionHistory> versionHistory;

    @JsonProperty("predecessor-version")
    public ArrayList<PredecessorVersion> getPredecessorVersion() {
        return this.predecessorVersion;
    }

    public void setPredecessorVersion(ArrayList<PredecessorVersion> predecessorVersion) {
        this.predecessorVersion = predecessorVersion;
    }

    ArrayList<PredecessorVersion> predecessorVersion;

    @JsonProperty("wp:featuredmedia")
    public ArrayList<WpFeaturedmedium> getWpFeaturedmedia() {
        return this.wpFeaturedmedia;
    }

    public void setWpFeaturedmedia(ArrayList<WpFeaturedmedium> wpFeaturedmedia) {
        this.wpFeaturedmedia = wpFeaturedmedia;
    }

    ArrayList<WpFeaturedmedium> wpFeaturedmedia;

    @JsonProperty("wp:attachment")
    public ArrayList<WpAttachment> getWpAttachment() {
        return this.wpAttachment;
    }

    public void setWpAttachment(ArrayList<WpAttachment> wpAttachment) {
        this.wpAttachment = wpAttachment;
    }

    ArrayList<WpAttachment> wpAttachment;

    @JsonProperty("wp:term")
    public ArrayList<WpTerm> getWpTerm() {
        return this.wpTerm;
    }

    public void setWpTerm(ArrayList<WpTerm> wpTerm) {
        this.wpTerm = wpTerm;
    }

    ArrayList<WpTerm> wpTerm;

    @JsonProperty("curies")
    public ArrayList<Cury> getCuries() {
        return this.curies;
    }

    public void setCuries(ArrayList<Cury> curies) {
        this.curies = curies;
    }

    ArrayList<Cury> curies;
}
