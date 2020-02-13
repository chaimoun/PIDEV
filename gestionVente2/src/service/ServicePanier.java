/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Commande;
import entite.LigneCommmande;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author Djemaiel
 */
public class ServicePanier {
    
    public void ajouterProduit(int produit, int qte, Map<Integer,Integer> panier){
        if(panier.containsKey(produit)){
            panier.put(produit, panier.get(produit)+qte);
        }
        else            
            panier.put(produit, qte);
    }
    
    public void supprimerProduit(int produit, int qte, Map<Integer,Integer> panier){
        if(panier.containsKey(produit)){
            if (panier.get(produit)> qte){
                panier.put(produit, panier.get(produit)-qte);
            } else
                panier.remove(produit);
        }
    }
    
    public void checkout (Map<Integer,Integer> panier){
        
        Commande c = new Commande();
        ServiceCommande sc = new ServiceCommande();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.setDate(sdf.format(cal.getTime()));
        c.setId_user(123);
        sc.ajouterComande(c);
        int idc = sc.derniereCommande();
        
        ServiceLigneCommande slc = new ServiceLigneCommande();
        
        for (Map.Entry<Integer, Integer> entry : panier.entrySet()) {
            LigneCommmande lc = new LigneCommmande();
            lc.setId_commande(idc);
            lc.setId_produit(entry.getKey());
            lc.setQuantite(entry.getValue());
            slc.ajouterLigneComande(lc);
		//System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
	}
    }
    
    public int totalPanier(Map<Integer,Integer> panier){
        
        ServiceProduit sp = new ServiceProduit();
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : panier.entrySet()) {
            total += sp.prixProduit(entry.getKey()) * entry.getValue();
        }
        return total;
    }
    
}
