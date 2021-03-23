package main;

import com.mysql.jdbc.PacketTooBigException;
import javafx.scene.shape.ClosePathBuilder;
import sn.isi.entities.Client;
import sn.isi.traitement.*;

import java.sql.ResultSet;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main  {
    public int id;
    public String nom;
    public String prenom;
    public String email;
    public String password;
    public String telephone;
    public static void main(String[] args) throws Exception {

        DB db = new DB();
        IClient client = (IClient) new ClientImp();
        Client c= new Client();
        //int add = client.add(c);
        List<Client> clients = client.getAll();
        Scanner scanner = new Scanner(System.in);
        Client client1 = null;
        String reponse = null;
        boolean b=false;

        do {
            System.out.println("===================================MENU=================================================");
            System.out.println("++++++++++++++++++++++++++++++++++A-CREATION CLIENT+++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++B-LISTE DES CLIENTS+++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++C-MODIFIER LES DONNEES D'UN CLIENT++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++D-RECHERCHER UN CLIENT++++++++++++++++++++++++++++++++");
            reponse =scanner.nextLine();
                if (reponse.equalsIgnoreCase("A")|| reponse.equalsIgnoreCase("B") || reponse.equalsIgnoreCase("C")|| reponse.equalsIgnoreCase("D")) {
                    b=true;

                }
                else
                {
                    System.out.println("CHOIX NON DISPONIBLE !!!!");
                }
           } while (b == false);
        if (reponse.equalsIgnoreCase("A"))
        {
            IClient iClient = new ClientImp();
            Client C = new Client();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++A-CREATION CLIENT+++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Saisissez le nom du client :");
            C.setNom(scanner.nextLine());
            System.out.println("Saisissez le prenom du client :");
            C.setPrenom(scanner.nextLine());
            System.out.println("Saisissez l'email du client :");
            C.setEmail(scanner.nextLine());
            System.out.println("Saisissez le password du client :");
            C.setPassword(scanner.nextLine());
            System.out.println("Saisissez le telephone du client :");
            C.setTelephone(scanner.nextLine());
            iClient.add(C);
        }
        if (reponse.equalsIgnoreCase("B"))
        {
            IClient iClient = new ClientImp();
            List <Client> listeclients = iClient.getAll();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++B-LISTE DES CLIENTS AJOUTES+++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            for (Client C : listeclients)
            {

                System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("L'id du client est : " +C.getId());
                System.out.println("Le nom du client est : " +C.getNom());
                System.out.println("Le prenom du client est : " +C.getPrenom());
                System.out.println("L'email du client est : " +C.getEmail());
                System.out.println("Le password du client est : " +C.getPassword());
                System.out.println("Le telephone du client est : " +C.getTelephone());

            }
        }

        if (reponse.equalsIgnoreCase("C")){
                db.open();
                String sql = "UPDATE client SET nom = ?, prenom = ?,email = ?, password = ?,telephone = ? WHERE id = ?";
                db.init(sql);
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++C-MODIFIER LES DONNEES DU CLIENT++++++++++++++++++++++++++++");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Entrer l'ID :");
                int nouveauId = Integer.parseInt(scanner.nextLine());
                System.out.println("Entrer le meme ID :");
                int ancienId = Integer.parseInt(scanner.nextLine());
                if (nouveauId == ancienId){
                IClient iClient = new ClientImp();
                Client C = new Client();
                System.out.println("veuillez saisir le nom:");
                C.setNom(scanner.nextLine());
                System.out.println("veuillez saisir le prenom:");
                C.setPrenom(scanner.nextLine());
                System.out.println("veuillez saisir l'email:");
                C.setEmail(scanner.nextLine());
                System.out.println("veuillez saisir le mot de passe:");
                C.setPassword(scanner.nextLine());
                System.out.println("veuillez saisir le tel:");
                C.setTelephone(scanner.nextLine());

                db.getPstm().setString(1, C.getNom());
                db.getPstm().setString(2, C.getPrenom());
                db.getPstm().setString(3, C.getEmail());
                db.getPstm().setString(4, C.getPassword());
                db.getPstm().setString(5, C.getTelephone());
                db.getPstm().setInt(6, ancienId);
                int ok = db.executeUpdate();
                System.out.println("-------------------------------");
                System.out.println("Client modifié avec succés !!!");


            }else {
                     System.out.println("L'id n'existe pas !");
                }
        }

        if (reponse.equalsIgnoreCase("D"))
        {
            IClient iClient = new ClientImp();
            Client C = new Client();
            db.open();
            String sql = "SELECT * FROM client";
            db.init(sql);
            iClient.rechercher(C);
            ResultSet res = db.executeSelect();
            db.getPstm().setString(1, C.getNom());
            db.getPstm().setString(2, C.getPrenom());
            db.getPstm().setString(3, C.getEmail());
            db.getPstm().setString(4, C.getPassword());
            db.getPstm().setString(5, C.getTelephone());
            int ok = db.executeUpdate();

        }
    }
}

