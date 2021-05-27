package ms.authentication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ms.authentication.entity.Client;
import ms.authentication.entity.db.User;
import ms.authentication.response.Response;
import ms.authentication.response.ResponseError;
import ms.authentication.service.IAuthenticationService;

@RestController
@RequestMapping("v1")
@CrossOrigin(origins = "*")
public class Controller {

	@Autowired
	private Environment environment;

	@Autowired
	private IAuthenticationService authenticationService;

	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<List<User>>> userAll() throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'userAll' | Port: '%s'", port));

		Response<List<User>> response;
		HttpStatus httpStatus;
		try {
			response = new Response<>(authenticationService.userAll());
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	@RequestMapping(value = "/document/{document}", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<User>> userByDocument(@PathVariable String document) throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'userByDocument' | Port: '%s'", port));

		Response<User> response;
		HttpStatus httpStatus;
		try {
			User user = authenticationService.userByDocument(document);
			if(user != null) {
				response = new Response<>(user);
				httpStatus = HttpStatus.OK;
			} else {
				response = new Response<>(new ResponseError("Error"));
				httpStatus = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	@HystrixCommand()
	public ResponseEntity<Response<User>> checkLogin(@RequestBody User user) throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'checkLogin' | Port: '%s'", port));

		User checkUser = authenticationService.checkLogin(user);
		
		Response<User> response;
		HttpStatus httpStatus;
		try {
			if(checkUser != null) {
				response = new Response<>(checkUser);
				httpStatus = HttpStatus.OK;
			} else {
				response = new Response<>(new ResponseError("Error"));
				httpStatus = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@HystrixCommand()
	public ResponseEntity<Response<Boolean>> updateUser(@RequestBody User user) throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'updateUser' | Port: '%s'", port));

		Response<Boolean> response;
		HttpStatus httpStatus;
		try {
			Boolean result = authenticationService.updateUser(user);
			
			if(result != null && result) {
				response = new Response<>(result);
				httpStatus = HttpStatus.OK;
			} else {
				response = new Response<>(new ResponseError("Error"));
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	@RequestMapping(value = "/getToken/{document}", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<String>> getToken(@PathVariable String document) throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'getToken' | Port: '%s'", port));

		Response<String> response;
		HttpStatus httpStatus;
		try {
			String token = authenticationService.getToken(document);
			if(token != null) {
				response = new Response<>(token);
				httpStatus = HttpStatus.OK;
			} else {
				response = new Response<>(new ResponseError("Error"));
				httpStatus = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	@RequestMapping(value = "/getBlackList/{document}", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<Boolean>> getBlackList(@PathVariable String document) throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'getBlackList' | Port: '%s'", port));

		Response<Boolean> response;
		HttpStatus httpStatus;
		try {
			Response<Client> responseClient = authenticationService.getClientByDocument(document);
			if(responseClient != null) {
				if(responseClient.getError() == null) {
					response = new Response<>(responseClient.getResult().getBlacklist());
					httpStatus = HttpStatus.OK;
				}else {
					response = new Response<>(new ResponseError("Error"));
					httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
				}
			} else {
				response = new Response<>(new ResponseError("Error"));
				httpStatus = HttpStatus.NOT_FOUND;
			}
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
		
	}

}