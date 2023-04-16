/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nambcse04832
 */
public class ShopInfo {
    private String address;
    private String email;
    private int tel;
    private String openHours;
    private String signature;
    private String introContent;
    private String introImage;

    public ShopInfo(String address, String email, int tel, String openHours, String signature, String introContent, String introImage) {
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.openHours = openHours;
        this.signature = signature;
        this.introContent = introContent;
        this.introImage = introImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIntroContent() {
        return introContent;
    }

    public void setIntroContent(String introContent) {
        this.introContent = introContent;
    }

    public String getIntroImage() {
        return introImage;
    }

    public void setIntroImage(String introImage) {
        this.introImage = introImage;
    }
    
}
