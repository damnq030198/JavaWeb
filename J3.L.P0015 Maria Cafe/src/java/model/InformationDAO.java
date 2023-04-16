/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Information;
import entity.OpeningHour;
import java.util.ArrayList;

/**
 *
 * @author vuhkse05427
 */
public class InformationDAO extends DataConfig {
    
    public ArrayList<OpeningHour> getOpeningHour() throws Exception {
        ArrayList<OpeningHour> openingHours = new ArrayList<>();
        String query = "select * from OpeningHour";
        try (Connection connection = getConnection();
                PreparedStatement pre = connection.prepareStatement(query);
                ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                OpeningHour hour = new OpeningHour();
                hour.setDays(rs.getString("Day"));
                hour.setHour(rs.getString("OpenTime"));
                openingHours.add(hour);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
        return openingHours;
    }
    
    public ArrayList<Contact> getContact() throws Exception {
        ArrayList<Contact> contacts = new ArrayList<>();
        String query = "select * from Contact";
        try (Connection connection = getConnection();
                PreparedStatement pre = connection.prepareStatement(query);
                ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setContact(rs.getString("Address"));
                contact.setMail(rs.getString("Email"));
                contact.setPhone(rs.getString("Tel"));
                contacts.add(contact);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
        return contacts;
    }
    
    public Information getInfo() throws Exception {
        Information info = new Information();
        String query = "select title, mapimage from Information";
        try (Connection connection = getConnection();
                PreparedStatement pre = connection.prepareStatement(query);
                ResultSet rs = pre.executeQuery()) {
            if (rs.next()) {
                info.setTitle(rs.getString("title"));
                info.setMapImage(rs.getString("mapimage"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
        
        info.setOpeningHour(getOpeningHour());
        info.setContact(getContact());
        return info;
    }
}
