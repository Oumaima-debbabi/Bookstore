/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase;

import java.sql.SQLException;
import purchase.Models.Produit;
import java.util.*;
import purchase.Models.Book;
import purchase.contrôleur.BookControleur;
/**
 *
 * @author asus
 */
public class Purchase {

   
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      System.out.println("-------------------Welcome to bookstore App-------------------\n\n");
      Scanner scanner = new Scanner( System.in ); 
      int choix = 0;
            Book b= new Book(); 
            BookControleur book= new BookControleur();
                    

         do {
            System.out.println("---------------------Menu--------------------");
            System.out.println("Please choose number");
            System.out.println("1: Add a new book");
            System.out.println("2: Display all the saved books");
            System.out.println("3: Delete a book");
            System.out.println("4: Update a book's information");
            System.out.println("5:the total price");
            System.out.println("6: close");
            choix = scanner.nextInt();
             switch(choix){
                case 1:{
                     
                   System.out.println("---------------Add book--------------");
                   System.out.println("Enter the book title");
                   String t=scanner.next();
                   System.out.println("Enter the book author");
                   String a=scanner.next();
                   System.out.println("Enter the book price");
                   Double p=scanner.nextDouble();
                   System.out.println("Enter the book relase");
                   String r=scanner.next();
                   b.setRelease(r);
                   b.setTitre(t);
                   b.setAuthor(a);
                   b.setPrice(p);
                   book.insert(b);
                  }break;
                case 2:{
                     System.out.println("------------Book list---------------------");
                     book.affichage();   
                  }break;
                case 3:{
                     System.out.println("Please entre the value of id of book that you want to delete");
                    int x=scanner.nextInt();
                    book.delete(x);
                    
                  }break;
                case 4:{
                     book.ModifyBookBD(b);
                   }break; 
                case 5:{
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
                         if(q>0 &&p>0){
                        System.out.println( "the total price for the given quantity= "+(s.calculateTotalPrice(q,p)));
              
                        } 
                         else{
                         System.out.println("Wrong try again");
                         }
                     }
                          //une fois l'une de valeur entrée est invalide une expcetion est detectée
                         catch(InputMismatchException e){
                         System.out.println("Wrong");
                             }
                    } break;
                case 6: {
                         System.out.println("That's all good bye!");
                         book.logout();
                         }
                   }
          }while(choix!=6);
        
     
 
       
    
        
    }
   
   

    }


    
    

                   
          
    
      
       
    
    
