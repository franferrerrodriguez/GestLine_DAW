package ms.authentication.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ms.authentication.entity.db.User;

public interface IAuthenticationRepository extends Repository<User, String> {

	public List<User> findAll();
	
	public User findByDocument(String document);
	
	public void save(User user);
	
}