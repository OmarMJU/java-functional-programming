package com.omju.excercises.composition;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Article {
    private final String name;
    private final String autor;
    private final String tag;
    private final Date published;

    public Article(String name, String autor, String tag, Date published) {
        this.name = name;
        this.autor = autor;
        this.tag = tag;
        this.published = published;
    }

    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public String getTag() {
        return tag;
    }

    public Date getPublished() {
        return published;
    }

    @SafeVarargs
    public static <T> List<T> gelAllArticles(T... articles) {
        return Arrays.asList(articles);
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", autor='" + autor + '\'' +
                ", tag='" + tag + '\'' +
                ", published=" + published +
                '}';
    }
}
