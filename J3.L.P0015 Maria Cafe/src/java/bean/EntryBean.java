/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Item;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EntryDAO;

/**
 *
 * @author vuhkse05427
 */
public class EntryBean implements Serializable{
    private Item entry;
    private int id;
    public EntryBean() {
        
    }
    
    public void setId(int id) {
        try {
            this.id = id;
            this.entry = new EntryDAO().getEntry(id);
        } catch (Exception ex) {
            Logger.getLogger(EntryBean.class.getName()).log(Level.SEVERE, null, ex);
            this.entry = null;
        }
    }
    public int getId() {
        return this.id;
    }
    
    
    public String getTitle() {
        return entry.getName();
    }
    
    public String getImagePath() {
        return entry.getImagePath();
    }
    
    public String getItemContent() {
        return entry.getItemContent();
    }
    
    public boolean isError() {
        return this.entry == null;
    }
    
}
