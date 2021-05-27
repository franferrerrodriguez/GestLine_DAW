package ms.client.management.service;

import java.util.List;

import ms.client.management.entity.db.Client;

public interface IClientManagementService {

	List<Client> clientAll();
	
	Client clientByDocument(String document);
	
	Boolean updateClient(Client client);

}