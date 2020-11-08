/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase;
class expectionNombre  extends Exception{};
/**
 *
 * @author asus
 */
public class Produit {
   private int qte;
   private float unitPrice;

   double calculateTotalPrice(int qte, float unitPrice){
       return qte*unitPrice;
   }
}
