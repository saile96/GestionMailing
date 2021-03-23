package sn.isi.traitement;

import sn.isi.entities.Client;

import java.util.List;

public interface IClient {
    public int add(Client c) throws Exception;
    public List<Client> getAll() throws Exception;
    public int update(Client c);
    public Client rechercher(Client c);

}
