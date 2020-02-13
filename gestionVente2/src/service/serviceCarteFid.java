/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.CarteFidelite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnexionBD;

/**
 *
 * @author Djemaiel
 */
public class serviceCarteFid {
     private Connection con=ConnexionBD.getinstance().getCnx();
    
    public void ajoutercarte (CarteFidelite c){
        try {
            Statement st = con.createStatement();
            String req ="INSERT INTO `carte_fidelite` (`Id_user`, `nb_point`, `date_debut`, `date_fin`, `type`) VALUES ('"+c.getIdUser()+"', '"+c.getNbPoints()+"', '"+c.getDateDebut()+"', '"+c.getDateFin()+"', '"+c.getType()+"');";
            
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(serviceCarteFid.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void affichercarte () {
        try {
            PreparedStatement pt =con.prepareStatement("select * from carte_fidelite");
            ResultSet rs = pt.executeQuery();
            
            while(rs.next()){
                System.out.println("carte [id:"+rs.getInt(1)+" ,user: "+rs.getInt(2)+", nb point  '"+rs.getInt(3)+"',date debut : '"+rs.getString(4)+"' date fin  "+rs.getString(5)+"type '"+rs.getString(6)+"']");
            }
        } catch (SQLException ex) {
            Logger.getLogger(serviceCarteFid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifiercarte (int id,String type, String date){
        try {
            PreparedStatement pt = con.prepareStatement("update carte_fidelite set type= ? , date_fin =? where id_CF=?");
            pt.setString(1,type);
            pt.setString(2, date);
            pt.setInt(3,id);
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceCarteFid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void supprimercarte (CarteFidelite l) {
        try {
            PreparedStatement pt =con.prepareStatement("delete from carte_fidelite where id_CF= ?");
            pt.setInt(1, l.getId());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceLivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
