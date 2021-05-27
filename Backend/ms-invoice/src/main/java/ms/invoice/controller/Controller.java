package ms.invoice.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import ms.invoice.entity.db.InvoiceDocument;
import ms.invoice.response.Response;
import ms.invoice.response.ResponseError;
import ms.invoice.service.IInvoiceService;

@RestController
@RequestMapping("v1")
@CrossOrigin(origins = "*")
public class Controller {

	@Autowired
	private Environment environment;

	@Autowired
	private IInvoiceService invoiceService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	private static final String EXTERNAL_FILE_PATH = "./src/main/resources/downloadinvoices/";

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<List<InvoiceDocument>>> invoiceAll() throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'invoiceAll' | Port: '%s'", port));
		
		Response<List<InvoiceDocument>> response;
		HttpStatus httpStatus;
		try {
			response = new Response<>(invoiceService.invoiceAll());
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<InvoiceDocument>> invoiceById(@PathVariable Long id) throws InterruptedException {

		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'invoiceById' | Port: '%s'", port));

		Response<InvoiceDocument> response;
		HttpStatus httpStatus;
		try {
			InvoiceDocument invoiceDocument = invoiceService.findById(id);
			
			if(invoiceDocument != null) {
				response = new Response<>(invoiceDocument);
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
	
	@RequestMapping(value = "/betweenDates/{document}/{startDate}/{endDate}", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<List<InvoiceDocument>>> betweenDates(@PathVariable String document, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) throws InterruptedException {
		
		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'betweenDates' | Port: '%s'", port));
		
		Response<List<InvoiceDocument>> response;
		HttpStatus httpStatus;
		try {
			response = new Response<>(invoiceService.findBetweenDates(document, startDate, endDate));
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	@RequestMapping(value = "/lastInvoices/{document}/{numInvoices}", method = RequestMethod.GET)
	@HystrixCommand()
	public ResponseEntity<Response<List<InvoiceDocument>>> lastInvoices(@PathVariable String document, @PathVariable Integer numInvoices) throws InterruptedException {
		
		String port = environment.getProperty("local.server.port");

		LOGGER.info(String.format("Called endpoint: 'lastInvoices' | Port: '%s'", port));
		
		Response<List<InvoiceDocument>> response;
		HttpStatus httpStatus;
		try {
			response = new Response<>(invoiceService.lastInvoices(document, numInvoices));
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			response = new Response<>(new ResponseError("Error"));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(response, httpStatus);
		
	}
	
	@RequestMapping(value = "downloadInvoice/{fileName:.+}", method = RequestMethod.GET)
	@HystrixCommand()
    public StreamingResponseBody downloadInvoice(HttpServletResponse response, @PathVariable("fileName") String fileName) throws IOException {
		
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        InputStream inputStream = new FileInputStream(new File(EXTERNAL_FILE_PATH + fileName));
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1)
                outputStream.write(data, 0, nRead);
            inputStream.close();
        };
        
    }
	
	@RequestMapping(value = "/showInvoice/{fileName:.+}", method = RequestMethod.GET)
	@HystrixCommand()
	public void showInvoice(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) throws IOException {

		File file = new File(EXTERNAL_FILE_PATH + fileName);
		if (file.exists()) {

			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null)
				mimeType = "application/octet-stream";

			response.setContentType(mimeType);

			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());

		}
	}

}