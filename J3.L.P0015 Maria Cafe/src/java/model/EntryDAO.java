/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vuhkse05427
 */
public class EntryDAO extends DataConfig {

    public Item getEntry(int id) throws Exception {
        Item result = new Item();
        String query = "select * from Item where id = ?";
        try (Connection conn = getConnection(); PreparedStatement pre = conn.prepareStatement(query);) {
            pre.setInt(1, id);
            try (ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setName(rs.getString("name"));
                    result.setImagePath(rs.getString("imagePath"));
                    result.setItemContent(rs.getString("itemContent"));
                    result.setShortContent(rs.getString("Desc"));
                    result.setPublishedDate(rs.getDate("publishedDate"));
                    result.setPrice(rs.getDouble("price"));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            throw e;
        }
        return result;
    }

    public ArrayList<Item> getLatestEntry() throws Exception {
        ArrayList<Item> result = new ArrayList<>();
        String query = "select top 2 * from Item order by publishedDate desc";
        try (
                Connection connection = getConnection();
                PreparedStatement pre = connection.prepareStatement(query);
                ResultSet rs = pre.executeQuery();) {
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setImagePath(rs.getString("imagePath"));
                item.setItemContent(rs.getString("itemContent"));
                item.setShortContent(rs.getString("Desc"));
                item.setPublishedDate(rs.getDate("publishedDate"));
                item.setPrice(rs.getDouble("price"));
                result.add(item);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
        return result;
    }

    public ArrayList<Item> getEntryInPage(int page) throws Exception {
        ArrayList<Item> result = new ArrayList<>();
        String query = "SELECT * FROM \n"
                + "	(SELECT  *,ROW_NUMBER() OVER (ORDER BY publishedDate) AS [row] FROM Item) r \n"
                + "	WHERE [row] between ? and ?";
        System.out.println(query);
        try (
                Connection conn = getConnection();
                PreparedStatement pre = conn.prepareStatement(query)) {
            int from = (page - 1) * DataConfig.getPageSize() + 1;
            int to = page * DataConfig.getPageSize();
            pre.setInt(1, from);
            pre.setInt(2, to);
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setImagePath(rs.getString("imagePath"));
                    item.setItemContent(rs.getString("itemContent"));
                    item.setShortContent(rs.getString("Desc"));
                    item.setPublishedDate(rs.getDate("publishedDate"));
                    item.setPrice(rs.getDouble("price"));
                    result.add(item);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
        return result;
    }
    
    
    public int getMaxPage() throws Exception{
        int result = 0;
        String query = "select count(id) as CNT from Item";
        try (
                Connection connection = getConnection();
                PreparedStatement pre = connection.prepareStatement(query);
                ResultSet rs = pre.executeQuery();) {
            if (rs.next()) {
                result = rs.getInt("CNT");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }
        int page = result / DataConfig.getPageSize();
        // if there is another partial page -> increase page by one
        if (result % DataConfig.getPageSize() != 0) page++;
        return page;
    }

}
