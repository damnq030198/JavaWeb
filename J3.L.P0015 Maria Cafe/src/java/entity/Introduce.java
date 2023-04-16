/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import model.DataConfig;

/**
 *
 * @author vuhkse05427
 */
public class Introduce {

    private String contentUp, contentDown, image;

    public Introduce() {
    }

    public String getContentUp() {
        return contentUp;
    }

    public String getContentDown() {
        return contentDown;
    }

    public String getImage() {
        return DataConfig.getImagePath() + "/" + image;
    }

    public void setContentUp(String contentUp) {
        this.contentUp = contentUp;
    }

    public void setContentDown(String contentDown) {
        this.contentDown = contentDown;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
