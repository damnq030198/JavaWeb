/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import model.DataConfig;
import java.sql.Date;

/**
 *
 * @author vuhkse05427
 */
public class Item {

    private int id;
    private String name;
    private String imagePath;
    private String itemContent;
    private String shortContent;
    private Date publishedDate;
    private double price;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return DataConfig.getImagePath() + "/" + imagePath;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getShortContent() {
        return shortContent;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
