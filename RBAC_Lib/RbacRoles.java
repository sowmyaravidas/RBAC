/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RBAC_Lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



@Path("/role")
public class RbacRoles {

    //@EJB
    //public RbacDB rdb;
    
    //Post method for inserting new roles into the Rbac database
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String postRole(String roleId, String roleName) throws InstantiationException, SQLException {
      /*  try {
            Connection cn = RbacDB.connectivity();
            Statement stmt = cn.createStatement();
           // String insert_query = "Insert into roles values('153','Sreepriya')";
            String insert_query = "Insert into roles values('?','?')";
            PreparedStatement ps = cn.prepareStatement(insert_query);
            ps.setString(1, roleId);
            ps.setString(2, roleName);
            ps.executeUpdate();
            return "Done";
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RbacRoles.class.getName()).log(Level.SEVERE, null, ex);
        }*/
      
       return "Error";
    }
    
    //The get method returns the role name correspnding to the role ID provided
    
    @Path("/{role_id}")
    @GET
    @Produces("text/html")
    public String getRole(@PathParam(value = "role_id") final String role_id) throws InstantiationException, SQLException, IllegalAccessException {
        try {
            Connection cn = RbacDB.connectivity();
            Statement stmt = cn.createStatement();
            String select_query = "select role_name from roles where role_id ='?'";
            PreparedStatement ps = cn.prepareStatement(select_query);
            ps.setString(1, role_id);
            ResultSet res = stmt.executeQuery(select_query);
          if( res.next()){
            return res.getString("role_name") ;                
            }
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RbacRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Path("/{role_id}")
    @DELETE
    public void deleteRole(@PathParam(value = "role_id") final String role_id) throws InstantiationException, SQLException {
        try {
            Connection cn = RbacDB.connectivity();
            Statement stmt = cn.createStatement();
            String select_query = "delete from roles where role_id ='?'";
            PreparedStatement ps = cn.prepareStatement(select_query);
            ps.setString(1, role_id);
            ps.executeUpdate(select_query);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RbacRoles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
