/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.EntryDAO;

/**
 *
 * @author vuhkse05427
 */
public class ProductBean implements Serializable {

    private int page;
    private ArrayList<Item> entries;
    private int maxPage;
    public ProductBean() {
        try {
            this.maxPage = new EntryDAO().getMaxPage();
        } catch (Exception ex) {
            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
            this.maxPage = -1   ;
        }
    }

    public ArrayList<Item> getEntries() {
        return this.entries;
    }

    public int getPage() {
        return this.page;
    }
    
    public int getMaxPage() {
        return maxPage;
    }

    public void setPage(int page) {
        try {
            this.page = page;
            this.entries = new EntryDAO().getEntryInPage(page);
        } catch (Exception ex) {
            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
            this.entries = null;
        }
    }
    
    public boolean isError() {
        return this.entries == null || this.page < 1 || this.page > maxPage;
    }

}
