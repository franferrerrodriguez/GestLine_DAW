package ms.client.management.controller;

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

import ms.client.management.entity.db.Client;
import ms.client.management.response.Response;
import ms.client.management.response.ResponseError;
import ms.client.management.service.IClientManagementService;

@RestController
@RequestMapping("v1")
@CrossOrigin(origins = "*")
public class Controller {

	@Autowired
	private Environment environment;

	@Autowired
	private IClientManagementService clientManagementService;

	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<List<Client>>> clientAll() throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'clientAll' | Port: '%s'", port));

		Response<List<Client>> response;
		HttpStatus httpStatus;
		try {
			response = new Response<>(clientManagementService.clientAll());
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	@RequestMapping(value = "/document/{document}", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<Client>> clientByDocument(@PathVariable String document) throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'clientByDocument' | Port: '%s'", port));

		Response<Client> response;
		HttpStatus httpStatus;
		try {
			Client client = clientManagementService.clientByDocument(document);
			
			if(client != null) {
				response = new Response<>(client);
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
	
	@RequestMapping(value = "/updateClient", method = RequestMethod.POST)
	@HystrixCommand()
	public ResponseEntity<Response<Boolean>> updateClient(@RequestBody Client client) throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'updateClient' | Port: '%s'", port));

		Response<Boolean> response;
		HttpStatus httpStatus;
		try {
			Boolean result = clientManagementService.updateClient(client);
			
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

}