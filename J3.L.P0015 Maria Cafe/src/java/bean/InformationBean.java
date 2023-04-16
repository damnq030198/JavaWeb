/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Contact;
import model.InformationDAO;
import java.io.Serializable;
import entity.Information;
import entity.OpeningHour;
import java.util.ArrayList;
import model.DataConfig;

/**
 *
 * @author vuhkse05427
 */
public class InformationBean implements Serializable {

    Information info;

    public InformationBean() {
        try {
            this.info = new InformationDAO().getInfo();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            this.info = null;
        }
    }

    public boolean isError() {
        return this.info == null;
    }

    public String getTitle() {
        return info.getTitle();
    }

    public ArrayList<Contact> getContact() {
        return info.getContact();
    }

    public String getMap() {
        return DataConfig.getImagePath() + "/" +  info.getMapImage();
    }

    public ArrayList<OpeningHour> getOpeningHour() {
        return info.getOpeningHour();
    }
}
