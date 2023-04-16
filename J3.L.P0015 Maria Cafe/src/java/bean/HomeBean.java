/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Introduce;
import model.EntryDAO;
import java.io.Serializable;
import java.util.ArrayList;
import entity.Item;
import model.IntroduceDAO;

/**
 *
 * @author vuhkse05427
 */
public class HomeBean implements Serializable {

    private ArrayList<Item> lastEntry;
    private Introduce intro;

    public HomeBean() {
        try {
            this.lastEntry = new EntryDAO().getLatestEntry();
            this.intro = new IntroduceDAO().getIntroduce();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            this.lastEntry = null;
        }
    }

    public ArrayList<Item> getLastestEntry() {
        return lastEntry;
    }

    public boolean isError() {
        return lastEntry == null;
    }

    public Introduce getIntroduce() {
        return this.intro;
    }

}
