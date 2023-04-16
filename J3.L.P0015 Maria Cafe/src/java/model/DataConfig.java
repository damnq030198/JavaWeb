/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author vuhkse05427
 */
public class DataConfig {

    private static String connUrl = "";
    private static String dbUser = "";
    private static String dbPass = "";
    private static String imgPath = "";
    private static int pageSize;
    private static String sqlClass = "";

    static {
        try {
            InitialContext initialContext = new InitialContext();
            Context environmentContext = (Context) initialContext.lookup("java:/comp/env");
            connUrl = (String) environmentContext.lookup("connUrl");
            sqlClass = (String) environmentContext.lookup("sqlClass");
            dbUser = (String) environmentContext.lookup("dbUser");
            dbPass = (String) environmentContext.lookup("dbPass");
            imgPath = (String) environmentContext.lookup("imgPath");
            pageSize = (int) environmentContext.lookup("pageSize");
        } catch (Exception ex) {
            Logger.getLogger(DataConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        try {
            Class.forName(sqlClass);
            return DriverManager.getConnection(connUrl, dbUser, dbPass);
        } catch (Exception ex) {
            Logger.getLogger(DataConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String getImagePath() {
        return imgPath;
    }

    public static void setImagePath(String imagePath) {
        DataConfig.imgPath = imagePath;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        DataConfig.pageSize = pageSize;
    }

}
