/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Boot;
import Model.BootFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author culle
 */
public class BootDAO extends DataMapper<Boot, Integer>{

    private static final BootDAO dao = new BootDAO(); 
    
    private BootDAO(){
        
    }
   
    public static BootDAO getInstance(){
        return dao;
   }
    
    @Override
    public Boot load(Boot id) {
        String qry = "SELECT * FROM BOOTS WHERE CODE = " + id.getCode();
        Boot bt = querySingle(qry);
        return bt;
    }
    
    @Override
    public Boot loadById(Integer id) {
        String qry = "SELECT * FROM BOOTS WHERE CODE = " + id;
        Boot bt = querySingle(qry);
        return bt;
    }

    @Override
    public ArrayList<Boot> findAllWhere(String condition) {
        //not a pressing issue
        return null;
    }

    @Override
    public ArrayList<Boot> loadAll() {
        String qry = "SELECT * FROM BOOTS";
        ArrayList<Boot> bts = queryMultiple(qry);
        return bts;
    }

    @Override
    public ArrayList<Boot> create(Boot item) {
        String insertString = "Insert INTO BOOTS (CODE, NAME, TYPE, DESCRIPTION, SIZE, COLOR, PRICE, BRAND) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement addBoot = conn.prepareStatement(insertString);
            addBoot.setInt( 1, item.getCode());
            addBoot.setString( 2, item.getName());
            addBoot.setString( 3, item.getType());
            addBoot.setString( 4, item.getDescription());
            addBoot.setInt( 5, item.getSize());
            addBoot.setString( 6, item.getColor());
            addBoot.setDouble( 7, item.getPrice());
            addBoot.setString( 8, item.getBrand());
            addBoot.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BootDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return loadAll();
    }

    @Override
    public ArrayList<Boot> createById(Boot item, Integer id) {
        item.setCode(id);
        return create(item);
    }

    @Override
    public ArrayList<Boot> updateById(Boot item, Integer id) {
        String updateString = "UPDATE BOOTS SET CODE = ?, NAME = ?, TYPE = ?, DESCRIPTION = ?, SIZE = ?, COLOR = ?, PRICE = ?, BRAND = ? WHERE CODE = ?";
        
        try {
            PreparedStatement addBoot = conn.prepareStatement(updateString);
            addBoot.setInt( 1, item.getCode());
            addBoot.setString( 2, item.getName());
            addBoot.setString( 3, item.getType());
            addBoot.setString( 4, item.getDescription());
            addBoot.setInt( 5, item.getSize());
            addBoot.setString( 6, item.getColor());
            addBoot.setDouble( 7, item.getPrice());
            addBoot.setString( 8, item.getBrand());
            addBoot.setInt( 9, id);
            addBoot.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BootDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadAll();
    }

    @Override
    public ArrayList<Boot> update(Boot item) {
        return updateById(item, item.getCode());
    }

    @Override
    public ArrayList<Boot> deleteById(Integer id) {
         String updateString = "DELETE FROM BOOTS WHERE CODE = ?";
        try {
            PreparedStatement addBoot = conn.prepareStatement(updateString);
            addBoot.setInt( 1, id);
            addBoot.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BootDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadAll();
    }

    @Override
    public ArrayList<Boot> delete(Boot id) {
        return deleteById(id.getCode());
    }

     @Override
    protected Boot querySingle(String qry){
        BootFactory bootMaker = new BootFactory();
        
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            ResultSet results = stmt.executeQuery();
            
            int code = -1;
            String name = "";
            String description = "";
            String type = "";
            int size =-1;
            String color = "";
            double price = -1;
            String brand = "";
            
            
            while (results.next()) {
                code = results.getInt("CODE");
                name = results.getString("NAME");
                description = results.getString("DESCRITION");
                type = results.getString("TYPE");
                size = results.getInt("SIZE");
                color = results.getString("COLOR");
                price = results.getDouble("PRICE");
                brand = results.getString("BRAND");
            }
            
            Boot bt = bootMaker.createBoot(code, name, type, description, size, color, price, brand);
            return bt;
        } catch (SQLException ex) {
            Logger.getLogger(BootDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getNewCode(){
        String qry = "SELECT MAX(CODE) FROM BOOTS";
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            ResultSet results = stmt.executeQuery();
            
            while (results.next()) {    
                return results.getInt(1) +1;
            }
            return 10000;
        } catch (SQLException ex) {
            Logger.getLogger(BootDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 10000;
    }
    
    @Override
    protected ArrayList<Boot> queryMultiple(String qry){
        BootFactory bootMaker = new BootFactory();
        ArrayList<Boot> bts = new ArrayList<Boot>();
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            ResultSet results = stmt.executeQuery();
            
            while (results.next()) {
                
                int code;
                String name;
                String description;
                String type;
                int size;
                String color;
                double price;
                String brand;
                
                code = results.getInt("CODE");
                name = results.getString("NAME");
                description = results.getString("DESCRIPTION");
                type = results.getString("TYPE");
                size = results.getInt("SIZE");
                color = results.getString("COLOR");
                price = results.getDouble("PRICE");
                brand = results.getString("BRAND");
                
                Boot bt = bootMaker.createBoot(code, name, type, description, size, color, price, brand);
                bts.add(bt);
            }
           
            return bts;
        } catch (SQLException ex) {
            Logger.getLogger(BootDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

  

}
