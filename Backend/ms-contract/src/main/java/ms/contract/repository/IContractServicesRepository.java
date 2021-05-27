package ms.contract.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ms.contract.entity.db.ContractServices;

public interface IContractServicesRepository extends Repository<ContractServices, Long> {

	public ContractServices findById(Long id);

	public List<ContractServices> findAll();

	public void save(ContractServices contractService);

}