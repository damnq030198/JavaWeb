/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ContactInfor;
import model.Infor;
import model.Shared;

/**
 *
 * @author sonnhhe130366
 */
public class FindUsController {

    public ArrayList<Infor> getFindUs(String data) throws Exception {
        ArrayList<Infor> list = new ArrayList<>();
        DBContext db = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        String sql = "select * from Infor where name = ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, data);
            rs = ps.executeQuery();
            while (rs.next()) {
                Infor in = new Infor();
                in.setId(rs.getString("id"));
                in.setName(rs.getString("name"));
                in.setContent(rs.getString("content"));
                list.add(in);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeEverething(con, ps, rs);
        }
        return list;
    }

    public ArrayList<ContactInfor> getContactInfor() throws Exception {
        ArrayList<ContactInfor> list = new ArrayList<>();
        String sql = "select * from ContactInfor";
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
                ContactInfor in = new ContactInfor();
                in.setId(rs.getString("id"));
                in.setContact(rs.getString("contact"));
                in.setDetail(rs.getString("detail"));
                list.add(in);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeEverething(con, ps, rs);
        }
        return list;
    }
}
