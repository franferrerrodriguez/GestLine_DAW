package ms.client.management.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ms.client.management.entity.db.Address;

public interface IAddressRepository extends Repository<Address, String> {

	public List<Address> findAll();
	
	public Address findById(Long id);
	
	public void save(Address address);

}