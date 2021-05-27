package ms.authentication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ms.authentication.caller.Caller;
import ms.authentication.entity.Client;
import ms.authentication.entity.db.User;
import ms.authentication.feign.ClientManagementFeign;
import ms.authentication.repository.IAuthenticationRepository;
import ms.authentication.response.Response;
import ms.authentication.service.IAuthenticationService;
import ms.authentication.util.Util;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

	@Autowired
	private ClientManagementFeign clientManagementFeign;
	
	@Autowired
	IAuthenticationRepository authenticationRepository;
	
	@Override
	public List<User> userAll() {
		return authenticationRepository.findAll();
	}
	
	@Override
	public User userByDocument(String document) {
		return authenticationRepository.findByDocument(document);
	}
	
	@Override
	public User checkLogin(User user) {
		for(User u : authenticationRepository.findAll())
			if((u.getEmail().equals(user.getEmail()) || u.getDocument().equals(user.getDocument())) && 
					u.getPassword().equals(user.getPassword())) {
				u = Util.setUserToken(u);
				authenticationRepository.save(u);
				return u;
			}
		return null;
	}

	@Override
	public Boolean updateUser(User user) {
		try {
			authenticationRepository.save(user);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public String getToken(String document) {
		try {
			return authenticationRepository.findByDocument(document).getToken();
		} catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public Response<Client> getClientByDocument(String document) {
		try {
			return clientManagementFeign.getClientByDocument(document);
		} catch(Exception e) {
			return null;
		}
	}

}