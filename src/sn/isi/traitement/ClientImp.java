package sn.isi.traitement;

import sn.isi.entities.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientImp implements IClient{
    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    @Override
    public int add(Client c) throws Exception {

        Scanner scanner = new Scanner(System.in);
                    db.open();
                    String sql ="INSERT INTO client VALUES(null, ?, ?, ?, ?, ?)";
                    db.init(sql);
                    db.getPstm().setString(1, c.getNom());
                    db.getPstm().setString(2, c.getPrenom());
                    db.getPstm().setString(3, c.getEmail());
                    db.getPstm().setString(4, c.getPassword());
                    db.getPstm().setString(5, c.getTelephone());
                    int ok = db.executeUpdate();
        return ok;
    }

    @Override
    public List<Client> getAll() throws Exception {
        List<Client> clients= new ArrayList<Client>();
        db.open();
        String sql = "SELECT * FROM client";
        db.init(sql);
        ResultSet res = db.executeSelect();

        while (res.next())
        {
            Client client = new Client();
            client.setId(res.getInt(1));
            client.setNom(res.getString(2));
            client.setPrenom(res.getString(3));
            client.setEmail(res.getString(4));
            client.setPassword(res.getString(5));
            client.setTelephone(res.getString(6));
            clients.add(client);
        }
        return clients;
    }

    @Override
    public int update(Client c) {
       try {
            db.open();
            String sql = "UPDATE client SET nom = ?, prenom = ?,email = ?,  password = ?,telephone = ? WHERE id = ?";
            db.init(sql);
            db.getPstm().setString(1, c.getNom());
            db.getPstm().setString(2, c.getPrenom());
            db.getPstm().setString(3, c.getEmail());
            db.getPstm().setString(4, c.getPassword());
            db.getPstm().setString(5, c.getTelephone());
            int ok = db.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return ok;

    }

    @Override
    public Client rechercher(Client c) {
        Scanner scanner = new Scanner(System.in);
        Client C = null;
        String email = null;
        List<Client> listeclients= new ArrayList<Client>();
        try {
            db.open();
            String sql = "SELECT * FROM client";
            db.init(sql);
            ResultSet res = db.executeSelect();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++D-RECHERCHER UN  CLIENT+++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Entrer l'email du client");
            c.setEmail(scanner.nextLine());
            while(res.next())
            {
                    C.setId(res.getInt(1));
                    C.setNom(res.getString(2));
                    C.setPrenom(res.getString(3));
                    C.setEmail(res.getString(4));
                    C.setPassword(res.getString(5));
                    C.setTelephone(res.getString(6));
            //lclients = new ArrayList<>();
           for (Client C1 : listeclients)
           {
                    if(c.getEmail() == C.getEmail()){
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("L'id du client est : " +C.getId());
                    System.out.println("Le nom du client est : " +C.getNom());
                    System.out.println("Le prenom du client est : " +C.getPrenom());
                    System.out.println("L'email du client est : " +C.getEmail());
                    System.out.println("Le password du client est : " +C.getPassword());
                    System.out.println("Le telephone du client est : " +C.getTelephone());
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                }
              }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return c;
    }
}
