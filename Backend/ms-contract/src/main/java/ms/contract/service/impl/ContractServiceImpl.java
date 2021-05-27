package ms.contract.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.contract.entity.db.Contract;
import ms.contract.entity.db.ContractServices;
import ms.contract.repository.IContractRepository;
import ms.contract.repository.IContractServicesRepository;
import ms.contract.service.IContractService;

@Service
public class ContractServiceImpl implements IContractService {

	@Autowired
	IContractRepository contractRepository;
	
	@Autowired
	IContractServicesRepository contractServicesRepository;
	
	@Override
	public List<Contract> contractAll() throws InterruptedException {
		return contractRepository.findAll();
	}
	
	@Override
	public Contract contractByDocument(String document) throws InterruptedException {
		return contractRepository.findByDocument(document);
	}

	@Override
	public Boolean updateContractsService(List<String> contractsService) throws InterruptedException {

		try {
			for(String service : contractsService) {
				String[] split = service.split(";");
				if(split.length == 2) {
					ContractServices c = contractServicesRepository.findById(Long.valueOf(split[0]));
					c.setActive(split[1].equals("A") ? true : false);
					contractServicesRepository.save(c);
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}

}