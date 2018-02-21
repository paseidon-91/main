/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.web.beans;

import java.awt.Image;
import java.sql.Date;

/**
 *
 * @author Alexp_000
 */
public class Book {

    private String name;
    private byte[] content;
    private int page_count;
    private String author;
    private String pub;
    private Image image;
    private String isbn;
    private Date publish_year;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublish_year(Date publish_year) {
        this.publish_year = publish_year;
    }

    public String getAuthor() {
        return author;
    }

    public String getPub() {
        return pub;
    }

    public String getIsbn() {
        return isbn;
    }

    public Date getPublish_year() {
        return publish_year;
    }
    
    public Book(String name, String author, String pub, Date publish_year, int page_count) {
        this.name = name;
        this.publish_year = publish_year;
        this.page_count = page_count;
        this.author = author;
        this.pub = pub;
    }

    public Book() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public String getName() {
        return name;
    }

    public int getPage_count() {
        return page_count;
    }

}
