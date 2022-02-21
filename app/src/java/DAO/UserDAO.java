/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Trolley;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends DataMapper<User, String>{
    
    private static final UserDAO dao = new UserDAO(); 
    
    private UserDAO(){
    }
   
    public static UserDAO getInstance(){
        return dao;
   }
    
    @Override
    public User load(User id) {
        String qry = "SELECT * FROM USERS WHERE EMAIL=" + "'" + id.getEmail() + "'";
        User usr = querySingle(qry);
        return usr;
    }
    
    @Override
    public User loadById(String id) {
        String qry = "SELECT * FROM USERS WHERE EMAIL=" + "'" + id + "'";
        User usr = querySingle(qry);
        return usr;
    }

    @Override
    public ArrayList<User> findAllWhere(String condition) {
        //not a pressing issue
        return null;
    }

    @Override
    public ArrayList<User> loadAll() {
        String qry = "SELECT * FROM USERS";
        ArrayList<User> usrs = queryMultiple(qry);
        return usrs;
    }

    @Override
    public ArrayList<User> create(User item) {
        
        String insertString = "Insert INTO USERS (EMAIL, PASSWORD, TYPE, FULLNAME, EIRCODE) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement addUser = conn.prepareStatement(insertString);
            addUser.setString( 1, item.getEmail());
            addUser.setString( 2, item.getPassword());
            addUser.setString( 3, item.getType());
            addUser.setString( 4, item.getFullName());
            addUser.setString( 5, item.getEircode());
            addUser.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return loadAll();
    }

    @Override
    public ArrayList<User> createById(User item, String id) {
        item.setEmail(id);
        return create(item);
    }

    @Override
    public ArrayList<User> updateById(User item, String id) {
        String updateString = "UPDATE USERS SET EMAIL = ?, PASSWORD = ?, TYPE = ?, FULLNAME = ?, EIRCODE = ? WHERE EMAIL = ?";
        
        try {
            PreparedStatement addUser = conn.prepareStatement(updateString);
            addUser.setString( 1, item.getEmail());
            addUser.setString( 2, item.getPassword());
            addUser.setString( 3, item.getType());
            addUser.setString( 4, item.getFullName());
            addUser.setString( 5, item.getEircode());
            addUser.setString( 6, id);
            addUser.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadAll();
    }

    @Override
    public ArrayList<User> update(User item) {
        return updateById(item, item.getEmail());
    }

    @Override
    public ArrayList<User> deleteById(String id) {
         String updateString = "DELETE FROM USERS WHERE EMAIL = ?";
        try {
            PreparedStatement addUser = conn.prepareStatement(updateString);
            addUser.setString( 1, id);
            addUser.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadAll();
    }

    @Override
    public ArrayList<User> delete(User id) {
        return deleteById(id.getEmail());
    }

     @Override
    protected User querySingle(String qry){
        User usr = new User();
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            ResultSet results = stmt.executeQuery();
            String email = "";
                String pass = "";
                String name = "";
                String type = "";
                String eir = "";
            while (results.next()) {
                email = results.getString("EMAIL");
                pass = results.getString("PASSWORD");
                name = results.getString("FULLNAME");
                type = results.getString("TYPE");
                eir = results.getString("EIRCODE");
                type = type.toUpperCase();
            }
            usr.setEmail(email);
            usr.setPassword(pass);
            usr.setFullName(name);
            usr.setType(type);
            usr.setEircode(eir);
            return usr;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    protected ArrayList<User> queryMultiple(String qry){
        ArrayList<User> usrs = new ArrayList<User>();
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            ResultSet results = stmt.executeQuery();
            
            while (results.next()) {
                User usr = new User();
                
                String email = "";
                String pass = "";
                String name = "";
                String type = "";
                String eir = "";
                
                email = results.getString("EMAIL");
                pass = results.getString("PASSWORD");
                name = results.getString("FULLNAME");
                type = results.getString("TYPE");
                eir = results.getString("EIRCODE");
                type = type.toUpperCase();
                
                usr.setEmail(email);
                usr.setPassword(pass);
                usr.setFullName(name);
                usr.setType(type);
                usr.setEircode(eir);
                usrs.add(usr);
            }
           
            return usrs;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
