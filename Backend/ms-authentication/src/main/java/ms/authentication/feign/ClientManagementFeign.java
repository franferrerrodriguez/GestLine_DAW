package ms.authentication.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ms.authentication.entity.Client;
import ms.authentication.response.Response;

@FeignClient(value = "jplaceholder", url = "${microservices.msclientmanagementv1}")
public interface ClientManagementFeign {

    @RequestMapping(method = RequestMethod.GET, value = "document/{document}", produces = "application/json")
    Response<Client> getClientByDocument(@PathVariable("document") String document);
	    
}