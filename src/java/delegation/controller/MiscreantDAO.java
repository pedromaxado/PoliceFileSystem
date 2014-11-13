/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package delegation.controller;

import delegation.model.Miscreant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MiscreantDAO {
    
    public enum QueryType {
      
        FullList ("SELECT * FROM meliantes ORDER BY crime,name"),
        OutLawList ("SELECT * FROM meliantes WHERE state='Foragido' ORDER BY name");
        
        private String option;
        
        private QueryType(String option) {
            this.option = option;
        }
        
        public String getQuery() {
            return this.option;
        }
        
    };

    private static Connection connection = ConnectionFactory.getConnection();
    
    public static void addMiscreant(Miscreant mc) throws SQLException {
        
        String sql = "INSERT INTO meliantes (name,cpf,address,crime,crimeDate,crimeTime,crimeLocation,state,picture) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, mc.getName());
        stmt.setString(2, mc.getCpf());
        stmt.setString(3, mc.getAddress());
        stmt.setString(4, mc.getCrime());
        stmt.setDate(5, mc.getCrimeDate());
        stmt.setString(6, mc.getCrimeTime());
        stmt.setString(7, mc.getCrimeLocation());
        stmt.setString(8, mc.getState());
        stmt.setString(9, mc.getPicture());
        
        stmt.execute();
        stmt.close();
        
    }
    
    public static void updateMiscreant(Miscreant mc) throws SQLException {
        
        String sql = "UPDATE meliantes SET name=?, cpf=?, address=?, crime=?, crimeDate=?, crimeTime=?, crimeLocation=? WHERE ID=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, mc.getName());
        stmt.setString(2, mc.getCpf());
        stmt.setString(3, mc.getAddress());
        stmt.setString(4, mc.getCrime());
        stmt.setDate(5, mc.getCrimeDate());
        stmt.setString(6, mc.getCrimeTime());
        stmt.setString(7, mc.getCrimeLocation());
        stmt.setInt(8, mc.getId());
        
        stmt.execute();
        stmt.close();
        
        String sql2 = "UPDATE meliantes SET picture=?, state=? WHERE name=?";
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        
        stmt2.setString(1, mc.getPicture());
        stmt2.setString(2, mc.getState());
        stmt2.setString(3, mc.getName());
        
        stmt2.execute();
        stmt2.close();
        
    }
    
    public static void deleteMiscreant(int id) throws SQLException {
        
        String sql = "DELETE FROM meliantes WHERE ID=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
        
    }
    
    public static Miscreant getMiscreant(int id) throws SQLException {
        
        Miscreant mc = new Miscreant();
        
        String sql = "SELECT * FROM meliantes WHERE ID=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()) {
            
            mc.setId(rs.getInt("ID"));
            mc.setName(rs.getString("name"));
            mc.setCpf(rs.getString("cpf"));
            mc.setAddress(rs.getString("address"));
            mc.setCrime(rs.getString("crime"));
            mc.setCrimeDate(rs.getDate("crimeDate"));
            mc.setCrimeTime(rs.getString("crimeTime"));
            mc.setCrimeLocation(rs.getString("crimeLocation"));
            mc.setState(rs.getString("state"));
            mc.setPicture(rs.getString("picture"));
            
        }
        
        stmt.close();
        rs.close();
        
        return mc;
        
    }
    
    public static ArrayList getMiscreantList(QueryType qt) throws SQLException {
        
        ArrayList<Miscreant> list = new ArrayList<>();
        
        String sql = qt.getQuery();
        PreparedStatement stmt = connection.prepareCall(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            
            Miscreant mc = new Miscreant();
            
            mc.setId(rs.getInt("ID"));
            mc.setName(rs.getString("name"));
            mc.setCpf(rs.getString("cpf"));
            mc.setAddress(rs.getString("address"));
            mc.setCrime(rs.getString("crime"));
            mc.setCrimeDate(rs.getDate("crimeDate"));
            mc.setCrimeTime(rs.getString("crimeTime"));
            mc.setCrimeLocation(rs.getString("crimeLocation"));
            mc.setState(rs.getString("state"));
            mc.setPicture(rs.getString("picture"));
            
            list.add(mc);
            
        }
        
        stmt.close();
        rs.close();
        
        return list;
        
    }
    
}
