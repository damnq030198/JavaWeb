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
public class Visit {
    String id, title, longContent, address, phone, wish, sign;

    public Visit() {
    }

    public Visit(String id, String title, String longContent, String address, String phone, String wish, String sign) {
        this.id = id;
        this.title = title;
        this.longContent = longContent;
        this.address = address;
        this.phone = phone;
        this.wish = wish;
        this.sign = sign;
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

    public String getLongContent() {
        return longContent;
    }

    public void setLongContent(String longContent) {
        this.longContent = longContent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

   
    
    
}
