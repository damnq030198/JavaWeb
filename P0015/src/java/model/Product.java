/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author nambcse04832
 */
public class Product {
    private int ID;
    private String entryName;
    private String entryContent;
    private String image;
    private Date dated;

    public Product(int ID, String entryName, String entryContent, String image, Date dated) {
        this.ID = ID;
        this.entryName = entryName;
        this.entryContent = entryContent;
        this.image = image;
        this.dated = dated;
    }

    Product() {
        
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryContent() {
        return entryContent;
    }

    public void setEntryContent(String entryContent) {
        this.entryContent = entryContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }
    
}
