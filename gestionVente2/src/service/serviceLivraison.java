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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import entite.livraison;
import util.ConnexionBD;

/**
 *
 * @author Djemaiel
 */
public class serviceLivraison {
     private Connection con=ConnexionBD.getinstance().getCnx();
    
    public void ajouterlivraison (livraison l){
        try {
            Statement st = con.createStatement();
            String req ="insert into livraison values("+l.getId_livaraison()+","+l.getId_commande()+","+l.getTotal()+",'"+l.getEtat()+"')";
            
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(serviceLivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void afficherlivraison () {
        try {
            PreparedStatement pt =con.prepareStatement("select * from livraison");
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
                System.out.println("livraison [id:"+rs.getInt(1)+" ,commande: "+rs.getInt(2)+", total"+rs.getFloat(3)+",etat: '"+rs.getString(4)+"']");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceLivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifierlivraison (int id,String nom){
        try {
            PreparedStatement pt = con.prepareStatement("update livraison set etat= ? where id_livraison=?");
            pt.setString(1,nom);
            pt.setInt(2,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceLivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimerlivraison (livraison l) {
        try {
            PreparedStatement pt =con.prepareStatement("delete from livraison where id_livraison = ?");
            pt.setInt(1, l.getId_livaraison());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceLivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
