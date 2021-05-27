package ms.invoice.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ms.invoice.entity.db.InvoiceDocument;

public interface IInvoiceRepository extends Repository<InvoiceDocument, Long> {

	public List<InvoiceDocument> findAll();
	
	public InvoiceDocument findById(Long id);

}