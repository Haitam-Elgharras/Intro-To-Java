package ma.enset.tpjdbc.com.dao;

import ma.enset.tpjdbc.com.dao.entities.Client;

import java.util.List;

public interface ClientDao extends Dao<Client,Integer>{
    List<Client> searchClientByQuery(String query);
}
