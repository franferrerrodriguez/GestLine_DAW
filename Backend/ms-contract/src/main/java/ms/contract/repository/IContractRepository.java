package ms.contract.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ms.contract.entity.db.Contract;

public interface IContractRepository extends Repository<Contract, String> {

	public Contract findByDocument(String document);

	public List<Contract> findAll();

}