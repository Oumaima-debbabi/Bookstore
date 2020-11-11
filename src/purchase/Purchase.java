/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase;

import java.util.*;
/**
 *
 * @author asus
 */
public class Purchase {

   
    public static void main(String[] args) {
     
        Scanner scanner = new Scanner( System.in );
     
        Produit s=new Produit();
        boolean res=false;
         
         try{
              
             //entrer la valeur de quantité
               System.out.println("Please enter the quantity");
               //lire la valeur entrée
              int q = scanner.nextInt();
 
               //entrer le prix 
              
               System.out.println("Please enter price"); 
               //lire le prix
               float p=scanner.nextFloat();
               //calculer et afficher le prix totale 
               if(q>0 &&p>00){
               System.out.println( "the total price for the given quantity= "+(s.calculateTotalPrice(q,p)));
              
               } else{
                   System.out.println("Wrong try again");
               }
           }
            //une fois l'une de valeur entrée est invalide une expcetion est detectée
         catch(InputMismatchException e){
                     System.out.println("Wrong");
         }
    }
    }
    

                   
          
    
      
       
    
    
