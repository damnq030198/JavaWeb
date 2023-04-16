/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author sonnhhe130366
 */
public class Serviced {
    String id, title, content, displayDate;
    Date date; 

    public Serviced() {
    }

    public Serviced(String id, String title, String content, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
    }
    public void getFormatDate() {
        String format = "dd-MMMM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        displayDate = sdf.format(date);
    }
}
