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
import model.Article;
import model.MenuItem;

/**
 *
 * @author sonnhhe130366
 */
public class MenuController {

    public ArrayList<Article> getMenuList(int pageindex, int pagesize) throws Exception {
        ArrayList<Article> list = new ArrayList<>();
        String sql = "select * from ( select ROW_NUMBER() over (order by id ASC) as rownum, m.*\n"
                + "from Article m where id not in (0,996,997,998,999)) as a\n"
                + "where rownum >= (?-1)* ? + 1  and rownum <= (?*?)";
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
                Article mi = new Article();
                mi.setId(rs.getString("id"));
                mi.setImgLink(db.folderImg + rs.getString("imgLink"));
                mi.setFullContent(rs.getString("fullContent"));
                mi.setTitle(rs.getString("title"));
                list.add(mi);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeEverething(con, ps, rs);
        }
        return list;
    }

    public int count() throws Exception {
        String sql = "select COUNT(*) as Totalrow from (\n"
                + "  select ROW_NUMBER() over (order by id ASC) as rownum, m.* \n"
                + "  from Article m where m.id not in (0,996,997,998,999)) as a ";
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
