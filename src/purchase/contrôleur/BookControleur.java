/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.contrôleur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import purchase.Models.Book;
import purchase.SeConnecter;



/**
 *
 * @author asus
 */
public class BookControleur {

 SeConnecter con;
 PreparedStatement ps ;
    public BookControleur() throws ClassNotFoundException, SQLException {
      
  
      String url = "jdbc:mysql://localhost/bookstore?useUnicode=true&use"+
               "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
     String login = "root";
     String password="";
        con= new SeConnecter(url,login,password);
    }
    //search by id
        public ResultSet FindId(int id) {
        ResultSet res = null;
        try {
            String req = "SELECT * FROM books WHERE id = ?";
            PreparedStatement ps = SeConnecter.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            res = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
       
    public int insert(Book b){
        try {
   String req = "insert into books (`title`,`author`,price,`release`) "
                    + "values ('" + b.getTitre() + "','" + b.getAuthor() + "','" + b.getPrice() + "','" + b.getRelease() + "')";

            PreparedStatement preparedStmt = SeConnecter.getConnection().prepareStatement(req);

            preparedStmt.execute();
            System.out.println("book added with success");
        } catch (SQLException ex) {
            Logger.getLogger(SeConnecter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
   /*  public static ArrayList getListBook() {
        Book book = null;
        ArrayList<Book> list = new ArrayList();

        try {
            ResultSet r;
            Statement st;

            String req = ("select * from books ");
            st = SeConnecter.getConnection().createStatement();
            r = st.executeQuery(req);
            while (r.next()) {
                book = new Book(r.getInt(1), r.getString(4), r.getString(3), r.getInt(2), r.getString(5));

                list.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }*/
    public void affichage(){
        try {
            Statement st;
            ResultSet rs;
            String req=("SELECT * from books");
            st = SeConnecter.getConnection().prepareStatement(req);
          
          rs=st.executeQuery(req);
            while(rs.next()){
                System.out.println("BOOK n° "+rs.getInt(1)+":\nprice: "+rs.getInt(2)
                        +"\nTitre: "+rs.getString(3)+"\nAuthor :"+ rs.getString(4)+"\nRelease:"+rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SeConnecter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

         
//delet book
    public void delete(int id) {
        try {if (FindId(id) == null) {
                    System.out.println("there is no such book with that id");
                } else {

                    System.out.println("YOU'RE GOING TO DELETE THE BOOK N° " + id + "!");
                    PreparedStatement stm = SeConnecter.getConnection().prepareStatement("DELETE FROM `books` WHERE id=?");
                    stm.setInt(1, id);

                    stm.executeUpdate();

                    System.out.println("BOOK DELETED SUCCESSFULLY");
                }
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }

 public static void ModifyBookBD(Book b) {
        if (b != null) {
            
            String req = "update books set `title` = '"+b.getTitre()+"', `author` = '"+b.getAuthor()
                    +"', `price`='"+b.getPrice()+"', `release`= '"+b.getRelease()+"' where `id` = "+b.getId();
            try {
              
                PreparedStatement preparedStmt = SeConnecter.getConnection().prepareStatement(req);
                preparedStmt.execute();
                System.out.println("Le nom du livre a ete modifier avec succee!");
            } catch (SQLException ex) {
                Logger.getLogger(BookControleur.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("ce livre n'existe pas, verifier l'id ");
        }
  
    }
     public void logout() {
        try {
            SeConnecter.getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(BookControleur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
