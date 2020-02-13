/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionvente2;
import entite.CarteFidelite;
import service.serviceCarteFid;
import entite.Commande;
import service.serviceLivraison;
import entite.livraison;
import java.util.HashMap;
import java.util.Map;
import service.ServiceCommande;
import service.ServicePanier;

/**
 *
 * @author Djemaiel
 */
public class GestionVente2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        livraison l= new livraison(25,1,1,"en");
        livraison L1= new livraison(26,3,3,"Farah");
*/
        /*
          serviceLivraison srv = new serviceLivraison();
          //srv.ajouterlivraison(l);
         //  srv.ajouterlivraison(L1);
         Commande c =new Commande();
         c.setDate("01/01/2020");
         c.setId_user(123);
         ServiceCommande sc=new ServiceCommande();
         sc.ajouterComande(c);
         */
        // srv.supprimerlivraison(l);
      //   srv.modifierlivraison(26, "chaima");
        //srv.afficherlivraison();
        
        
        
        
        
        Map<Integer,Integer> panier = new HashMap<Integer, Integer>();
        
        ServicePanier ps = new ServicePanier();
        ps.ajouterProduit(1, 5, panier);
        ps.ajouterProduit(1, 5, panier);
        ps.ajouterProduit(2, 10, panier);
        ps.ajouterProduit(123, 5, panier);
        
        //nahi 3 kaabet mel panier
        ps.supprimerProduit(1, 3, panier);
        //nahi produit mel panier
        ps.supprimerProduit(123, panier.get(123), panier);
        
        
        ps.checkout(panier);
        
        System.out.println(ps.totalPanier(panier));
     /*serviceCarteFid cf = new serviceCarteFid();
     CarteFidelite c = new CarteFidelite(1,22,"11/12/202","11/12/2020","gold");
     //cf.ajoutercarte(c);
     
     cf.modifiercarte(2, "update", "31/12/2020");
     c.setId(2);
     cf.supprimercarte(c);*/
        

// TODO code application logic here
    }
    
    
    
}
