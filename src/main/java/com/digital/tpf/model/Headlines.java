package com.digital.tpf.model;

import java.util.List;

public class Headlines {

    private final String status;
    private final int totalResults;
    private final List<Article> articles;

    public Headlines(String status, int totalResults, List<Article> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
