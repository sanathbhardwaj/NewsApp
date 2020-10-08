package com.digital.tpf.model;

public class HeadlinesModel {

    String title;
    String publishDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public HeadlinesModel(String title, String publishDate) {
        this.title = title;
        this.publishDate = publishDate;
    }
}
