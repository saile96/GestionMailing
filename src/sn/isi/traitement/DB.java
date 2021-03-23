package sn.isi.traitement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    //Pour la connexion
    private Connection connect;
    //Pour les resultats des requetes de type SELECT
    private ResultSet rs;
    //Pour les requetes preparées
    private PreparedStatement pstm;
    //Pour les requetes de type mis à jour (INSERT, UPDATE,DELETE)
    private int ok;
    //permet d'ouvrir la connexion à la base
    public void open() throws Exception {
        String url = "jdbc:mysql://localhost:3306/gestionmailing";
        String mysqluser = "root";
        String mysqlpassword = "";
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection(url, mysqluser, mysqlpassword);
    }


    public void init(String sql) throws Exception
    {
        pstm = connect.prepareStatement(sql);
    }
    public int executeUpdate() throws Exception
    {
        int ok = 0;
        ok = pstm.executeUpdate();
        return ok;
    }

    public ResultSet executeSelect() throws Exception
    {
        rs = pstm.executeQuery();
        return rs;
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    //permet de fermer la connexion
    public void close() throws Exception {
        if (connect!= null) {
            connect.close();
        }
    }
}

