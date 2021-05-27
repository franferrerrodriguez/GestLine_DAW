package ms.client.management.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ms.client.management.entity.db.Billing;

public interface IBillingRepository extends Repository<Billing, String> {

	public List<Billing> findAll();
	
	public Billing findById(Long id);
	
	public void save(Billing billing);

}