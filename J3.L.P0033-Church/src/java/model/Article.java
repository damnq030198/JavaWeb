/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sonnhhe130366
 */
public class Article {
    String rowCount;
    String id;
    String title;
    String imgLink;
    String shortContent;
    String fullContent;

    public Article() {
    }

    public Article(String rowCount, String id, String title, String imgLink, String shortContent, String fullContent) {
        this.rowCount = rowCount;
        this.id = id;
        this.title = title;
        this.imgLink = imgLink;
        this.shortContent = shortContent;
        this.fullContent = fullContent;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getRowCount() {
        return rowCount;
    }

    public void setRowCount(String rowCount) {
        this.rowCount = rowCount;
    }
    
}
