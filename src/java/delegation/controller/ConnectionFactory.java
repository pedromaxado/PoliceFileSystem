/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delegation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author strudel
 */
public class ConnectionFactory {
    
    private static Connection connection;
    
    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if ( connection == null )
                connection = DriverManager.getConnection("jdbc:mysql://localhost/delegation", "pedro", "p");
//                connection = DriverManager.getConnection("jdbc:mysql://150.164.102.160/daw-aluno9", "daw-aluno9", "daw09");
            
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
