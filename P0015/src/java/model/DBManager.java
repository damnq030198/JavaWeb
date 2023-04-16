/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author nambcse04832
 */
public class DBManager {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Context context = new InitialContext();
            Context envContext = (Context) context.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("DBConnect");
            connection = ds.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
}
