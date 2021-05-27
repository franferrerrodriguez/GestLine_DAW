package ms.invoice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.invoice.entity.db.InvoiceDocument;
import ms.invoice.repository.IInvoiceRepository;
import ms.invoice.service.IInvoiceService;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

	@Autowired
	IInvoiceRepository invoiceRepository;

	@Override
	public List<InvoiceDocument> invoiceAll() throws InterruptedException {
		return invoiceRepository.findAll();
	}
	
	@Override
	public InvoiceDocument findById(Long id) {
		return invoiceRepository.findById(id);
	}
	
	@Override
	public List<InvoiceDocument> findBetweenDates(String document, Date invoiceDate, Date endDate) throws InterruptedException {
		return invoiceRepository.findAll()
				.stream()
				.filter(e -> e.getDocument().equals(document) && e.getInvoiceDate().after(invoiceDate) && e.getInvoiceDate().before(endDate))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<InvoiceDocument> lastInvoices(String document, Integer numInvoices) throws InterruptedException {
		int cont = 0;
		List<InvoiceDocument> listInvoiceDocument = new ArrayList<InvoiceDocument>();
		for(InvoiceDocument invoiceDocument : invoiceRepository.findAll()) {
			if(invoiceDocument.getDocument().equals(document) && cont < numInvoices) {
				listInvoiceDocument.add(invoiceDocument);
				cont++;
			}
		}
		return listInvoiceDocument;
	}

}