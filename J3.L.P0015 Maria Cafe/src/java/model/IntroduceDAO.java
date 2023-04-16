package model;

import entity.Introduce;
import entity.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vuhkse05427
 */
public class IntroduceDAO extends DataConfig{
    public Introduce getIntroduce() throws Exception {
        Introduce intro = new Introduce();
        String query = "select * from Introduction";
        try (Connection connection = getConnection()) {
            PreparedStatement pre = connection.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                intro.setImage(rs.getString("image"));
                intro.setContentUp(rs.getString("contentUp"));
                intro.setContentDown(rs.getString("contentDown"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw e;
        }

        return intro;
    }
    
    
}
