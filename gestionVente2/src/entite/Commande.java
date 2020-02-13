/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Djemaiel
 */
public class Commande {
    private int id;
    private String date;
    private int id_user;

    public Commande() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", date=" + date + ", id_user=" + id_user + '}';
    }
    
    
    
    
}
