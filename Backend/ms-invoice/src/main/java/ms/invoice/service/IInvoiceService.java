package ms.invoice.service;

import java.util.Date;
import java.util.List;

import ms.invoice.entity.db.Invoice;
import ms.invoice.entity.db.InvoiceDocument;

public interface IInvoiceService {

	List<InvoiceDocument> invoiceAll() throws InterruptedException;
	
	InvoiceDocument findById(Long id);
	
	List<InvoiceDocument> findBetweenDates(String document, Date startDate ,Date endDate) throws InterruptedException;
	
	List<InvoiceDocument> lastInvoices(String document, Integer numInvoices) throws InterruptedException;
	
}