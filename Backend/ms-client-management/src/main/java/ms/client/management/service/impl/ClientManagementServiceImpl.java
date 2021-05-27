package ms.client.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.client.management.entity.db.Client;
import ms.client.management.repository.IAddressRepository;
import ms.client.management.repository.IBillingRepository;
import ms.client.management.repository.IClientRepository;
import ms.client.management.service.IClientManagementService;

@Service
public class ClientManagementServiceImpl implements IClientManagementService {

	@Autowired
	IClientRepository clientRepository;
	
	@Autowired
	IAddressRepository addressRepository;
	
	@Autowired
	IBillingRepository billingRepository;

	@Override
	public List<Client> clientAll() {
		return clientRepository.findAll();
	}
	
	@Override
	public Client clientByDocument(String document) {
		return clientRepository.findByDocument(document);
	}
	
	@Override
	public Boolean updateClient(Client client) {
		try {
			clientRepository.save(client);
			addressRepository.save(client.getAddress());
			billingRepository.save(client.getBilling());
			addressRepository.save(client.getBilling().getAddress());
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}