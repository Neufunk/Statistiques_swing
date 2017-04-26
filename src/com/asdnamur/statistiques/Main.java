package com.asdnamur.statistiques;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
// Lancement de la fenêtre principale
        System.out.println("Ouverture de la page principale...");
        try {
            HomePage fen = new HomePage();
            System.out.println("Succès");
        } catch (Exception e) {
            System.err.println("Exception trouvée : ");
            System.err.println(e.getMessage());
        }
            System.out.println("Connexion à la base de donnée...");
            try{
// Load MS accces driver class
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
// specify url, username, password - make sure these are valid
                Connection connexion=DriverManager.getConnection("jdbc:ucanaccess://P:/INFORMATIQUE/Statistiques SI.accdb","johnathanv","liblum");
                System.out.println("Connexion effectuée");
            }catch(Exception e1){
                System.err.println("Exception trouvée : ");
                System.err.println(e1.getMessage());
            }
        }
    }


