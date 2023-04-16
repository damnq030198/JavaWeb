/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DBContext.folderImg;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Article;
import model.Shared;
import model.Visit;

/**
 *
 * @author sonnhhe130366
 */
public class HomeController {

    public ArrayList<Shared> getSocial() throws Exception {
        ArrayList<Shared> list = new ArrayList<>();
        String sql = "select * from Share";
        DBContext db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Shared s = new Shared();
                s.setIcon(db.folderImg + rs.getString("icon"));
                s.setSocialNetwork(rs.getString("socialNetwork"));
                s.setUrl(rs.getString("url"));
                list.add(s);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeEverething(con, ps, rs);
        }
        return list;
    }

    public ArrayList<Article> getMenu() throws Exception {
        ArrayList<Article> list = new ArrayList<>();
        String sql = "select top 2 * from (select ROW_NUMBER() over "
                + "(order by [date] DESC) as rownum, a.* from Article a\n"
                + ") as a";
        DBContext db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Article a = new Article();
                a.setRowCount(rs.getString("rownum"));
                a.setId(rs.getString("id"));
                a.setTitle(rs.getString("title"));
                a.setImgLink(db.folderImg + rs.getString("imgLink"));
                a.setShortContent(rs.getString("shortContent"));
                a.setFullContent(rs.getString("fullContent"));
                list.add(a);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeEverething(con, ps, rs);
        }
        return list;
    }

   public Article getAbout(String id) throws Exception{
        Article a = new Article();
        String sql = "select * from Article a where a.id = ?";
        DBContext db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.setId(rs.getString("id"));
                a.setTitle(rs.getString("title"));
                a.setImgLink(db.folderImg + rs.getString("imgLink"));
                a.setShortContent(rs.getString("shortContent"));
                a.setFullContent(rs.getString("fullContent"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeEverething(con, ps, rs);
        }
        return a;
   }
     public Article getDetail(String id) throws Exception{
        Article a = new Article();
        String sql = "select * from Article a where a.id = ? and a.id not in (0,996,997,998,999)";
        DBContext db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.setId(rs.getString("id"));
                a.setTitle(rs.getString("title"));
                a.setImgLink(db.folderImg + rs.getString("imgLink"));
                a.setShortContent(rs.getString("shortContent"));
                a.setFullContent(rs.getString("fullContent"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeEverething(con, ps, rs);
        }
        return a;
   }

}
