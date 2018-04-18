/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author m-besnard
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_MYSQL {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC?useSSL=false";
        String user = "root";
        String passwd = "";
        try {
// Etape 1 – Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");
// Etape 2 Connexion à la base de données
            Connection con = DriverManager.getConnection(url, user, passwd);
// Etape 3 – Création du curseur Statement
            Statement stmt = con.createStatement();
// Etape 4 – Exécution de la requête
            ResultSet rs = stmt.executeQuery("Select * from Personne ");
// Etape 5 – Exploitation des résultats
            while (rs.next()) {
                int num_pers = rs.getInt("num_pers");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                System.out.println(num_pers + " " + nom + " " + prenom + " ");
            }
// Etape 6- Fermeture des flots mémoire
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" Exception : " + e + " levée!");
        }

}
        
    public void insertTable() {
        String url = "jdbc:mysql://localhost:3306/JDBC?useSSL=false";
        String user = "root";
        String passwd = "BESNhm77520";
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Num pers: ");
        int num_pers = sc.nextInt();
        System.out.println("Num colloque: ");
        int num_col = sc.nextInt();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, passwd);
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO `Inscrire`(num_pers,num_col)" + "VALUE ('" + num_pers + "','" + num_col + "')");
            System.out.println("Inscription effectuée! ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
