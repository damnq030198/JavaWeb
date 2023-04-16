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
import model.Serviced;

/**
 *
 * @author sonnhhe130366
 */
public class ServiceController {

    public ArrayList<Serviced> getServiceList(int pageindex, int pagesize) throws Exception {
        ArrayList<Serviced> list = new ArrayList<>();
        String sql = "select * from ( select ROW_NUMBER() over (order by id ASC) as rownum, m.*\n"
                + "                from Service m) as a\n"
                + "                where rownum >= (?-1)* ? + 1  and rownum <= (?*?)";
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);
            ps.setInt(3, pagesize);
            ps.setInt(4, pageindex);
            rs = ps.executeQuery();
            while (rs.next()) {
                Serviced mi = new Serviced();
                mi.setId(rs.getString("id"));
                mi.setDate(rs.getDate("date"));
                mi.getFormatDate();
                mi.setTitle(rs.getString("title"));
                mi.setContent(rs.getString("content"));
                list.add(mi);
            }
        } catch (Exception e) {
            e.getMessage();
            throw e;
        } finally {
            db.closeEverething(con, ps, rs);
        }
        return list;
    }

    public int count() throws Exception {
        String sql = "select COUNT(id) as Totalrow from (\n"
                + "               select ROW_NUMBER() over (order by id ASC) as rownum, m.*\n"
                + "                from Service m) as a ";
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Totalrow");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeEverething(con, ps, rs);
        }
        return 0;
    }
}
