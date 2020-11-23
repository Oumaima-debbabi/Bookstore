/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.Models;

/**
 *
 * @author asus
 */
public class Book {
     private int id;
    private String titre;
    private String author;
    private double price;
    private String release; 

    public Book(String titre, String author, double price, String release) {
        this.titre = titre;
        this.author = author;
        this.price = price;
        this.release = release;
    }

    public Book(int id, String titre, String author, double price, String release) {
        this.id = id;
        this.titre = titre;
        this.author = author;
        this.price = price;
        this.release = release;
    }

    public Book() {
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", titre=" + titre + ", author=" + author + ", price=" + price + ", release=" + release + '}';
    }


    
}
