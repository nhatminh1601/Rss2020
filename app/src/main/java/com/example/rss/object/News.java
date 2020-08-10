package com.example.rss.object;

import java.io.Serializable;
import java.util.List;

public class News implements Serializable {
    int id;
    String name;
    String content;
    String url;
    List<News> subName;

    public News(int id, String name, String content, String url, List<News> subName) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.url = url;
        this.subName = subName;
    }

    public News() {
    }

    public News(int id, String name, String url, List<News> subName) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.subName = subName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<News> getSubName() {
        return subName;
    }

    public void setSubName(List<News> subName) {
        this.subName = subName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", subName=" + subName +
                '}';
    }
}
