package com.digital.tpf.model;

public class HeadlinesModel {

    String title;
    String publishDate;
    String urlToImage;
    String description;

    public HeadlinesModel(String title, String publishDate, String urlToImage, String description) {
        this.title = title;
        this.publishDate = publishDate;
        this.urlToImage = urlToImage;
        this.description = description;
    }

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

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
