package ms.contract.service;

import java.util.List;

import ms.contract.entity.db.Contract;

public interface IContractService {

	Contract contractByDocument(String document) throws InterruptedException;

	List<Contract> contractAll() throws InterruptedException;

	Boolean updateContractsService(List<String> contractsService) throws InterruptedException;
	
}