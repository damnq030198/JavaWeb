/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author vuhkse05427
 */
public class Information {

    private String title;
//    private String contact;
//    private String openingHour;
    private ArrayList<Contact> contact;
    private ArrayList<OpeningHour> openingHour;

    public void setContact(ArrayList<Contact> contact) {
        this.contact = contact;
    }

    public void setOpeningHour(ArrayList<OpeningHour> openingHour) {
        this.openingHour = openingHour;
    }

    public ArrayList<Contact> getContact() {
        return contact;
    }

    public ArrayList<OpeningHour> getOpeningHour() {
        return openingHour;
    }
    private String mapImage;
    
    
    

    public Information() {

    }

    public String getTitle() {
        return title;
    }


    public String getMapImage() {
        return mapImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setMapImage(String mapImage) {
        this.mapImage = mapImage;
    }

}
