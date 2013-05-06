/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RBAC_Lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sowcat
 */
public class RbacDB {

  public static Connection connectivity () throws InstantiationException, IllegalAccessException {
      
       Connection cn;
       try{
            
            Class.forName("org.postgresql.Driver").newInstance();
            System.out.println("postgresql JDBC Driver Registered!");
 
            String url = "jdbc:postgresql://localhost/postgres?user=sowcat&password=namahshivaya&ssl=true";
            cn = DriverManager.getConnection(url);
            return cn;
            
      /*      Statement stmt = cn.createStatement();
    
            
            String insert_query = "Insert into roles values('109','managr')";
            PreparedStatement ps = cn.prepareStatement(insert_query);
            ps.executeUpdate();
            
            //ResultSet res = stmt.executeQuery(insert_query);*/
          }    

            //Do something with the Connection
            catch (ClassNotFoundException e) {
            //Cannot register postgresql MySQL driver
            System.out.println("This is something you have not add in postgresql library to classpath!");
            }
       
            catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
        
  }

}

