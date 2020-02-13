/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnexionBD;

/**
 *
 * @author Djemaiel
 */
public class ServiceProduit {
      private Connection con=ConnexionBD.getinstance().getCnx();
      
    public int prixProduit(int id){
            int c = 0;
        try {
            PreparedStatement pt =con.prepareStatement("select prix from produit where id = "+id);
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
                c = rs.getInt(1);
//System.out.println("commande [id:"+rs.getInt(1)+" ,date: "+rs.getString(2)+",id_user: "+rs.getInt(2)+"]");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }        
            return c;
    }
}
