package ms.authentication.service;

import java.util.List;

import ms.authentication.entity.Client;
import ms.authentication.entity.db.User;
import ms.authentication.response.Response;

public interface IAuthenticationService {

	List<User> userAll();
	
	User userByDocument(String document);

	User checkLogin(User user);

	Boolean updateUser(User user);
	
	String getToken(String document);
	
	Response<Client> getClientByDocument(String document);
	
}