package ms.client.management.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ms.client.management.entity.db.Client;

public interface IClientRepository extends Repository<Client, String> {

	public List<Client> findAll();
	
	public Client findByDocument(String document);
	
	public void save(Client client);

}