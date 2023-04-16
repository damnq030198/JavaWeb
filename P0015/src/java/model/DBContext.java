/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nambcse04832
 */
public class DBContext {
    public static ArrayList<Product> getLatestProduct(int quantity) throws Exception {
        ArrayList<Product> listProducts = new ArrayList<>();
        try (Connection connection = DBManager.getConnection()) {
            String sql = "SELECT TOP (?) * "
                    + "FROM [Product] "
                    + "ORDER BY Date DESC";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, quantity);
                try (ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        int id = result.getInt("ID");
                        String entryName = result.getString("EntryName");
                        String entryContent = result.getString("EntryContent");
                        entryContent = entryContent.replaceAll("\n", "<br/>");
                        Date date = result.getDate("Date");
                        String image = result.getString("Image");
                        listProducts.add(new Product(id, entryName, entryContent, image, date));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProducts;
    }
    public static Product getProduct(int id) throws Exception {
        try (Connection connection = DBManager.getConnection()) {
            String sql = "SELECT * "
                    + "FROM [Product] "
                    + "WHERE ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        String entryName = result.getString("EntryName");
                        String entryContent = result.getString("EntryContent");
                        entryContent = entryContent.replaceAll("\n", "<br/>");
                        Date date = result.getDate("Date");
                        String image = result.getString("Image");
                        return new Product(id, entryName, entryContent, image, date);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public static ShopInfo getShopInfo() throws Exception {
        try (Connection connection = DBManager.getConnection()) {
            String sql = "SELECT * "
                    + "FROM [ShopAbout] ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        String address = result.getString("Address");
                        int tel = result.getInt("Tel");
                        String email = result.getString("Email");
                        String openingHours = result.getString("OpeningHours");
                        openingHours = openingHours.replaceAll("\n", "<br/>");
                        String signature = result.getString("Signature");
                        String introContent = result.getString("IntroContent");
                        String introImage = result.getString("IntroImage");
                        return new ShopInfo(address, email, tel, openingHours, signature, introContent, introImage);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    
    public static CakeAbout getCakeAbout() throws Exception {
        try (Connection connection = DBManager.getConnection()) {
            String sql = "SELECT * "
                    + "FROM [CakeAbout] ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        String content = result.getString("Content");
                        String image = result.getString("Image");
                        String title = result.getString("Title");
                        return new CakeAbout(title, content, image);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
