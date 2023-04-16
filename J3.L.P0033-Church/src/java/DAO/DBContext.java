/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author sonnhhe130366
 */
public class DBContext {

    static InitialContext init;
    static Context envi;
    static String server;
    static String DBName;
    static String folderImg;
    static String port;
    public static String book;

    static {
        try {
            init = new InitialContext();
            envi = (Context) init.lookup("java:comp/env");
            server = (String) envi.lookup("server");
            DBName = (String) envi.lookup("DBName");
            port = (String) envi.lookup("port");
            folderImg = (String) envi.lookup("img");
            book = (String) envi.lookup("book");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Connection getConnection() {
        try {
            String xUrl = "jdbc:sqlserver://" + server + ":" + port + ";databaseName = " + DBName + "; integratedSecurity = true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(xUrl);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void closeEverething(Connection con, PreparedStatement ps, ResultSet rs) throws Exception {
        try {
            if (rs != null || !rs.isClosed()) {
                rs.close();
            }
            if (ps != null || !ps.isClosed()) {
                ps.close();
            }
            if (con != null || !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
