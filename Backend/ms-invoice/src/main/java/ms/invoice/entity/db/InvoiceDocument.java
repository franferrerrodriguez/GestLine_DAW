package ms.invoice.entity.db;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "invoicedocument")
public class InvoiceDocument {
	
	@Id
	private Long id;
	
	@Column(name = "document", updatable = false, nullable = false)
	private String document;
	
	@Column(name = "invoice_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date invoice_date;
	
	@OneToMany(mappedBy="invoiceDocument", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Invoice> invoices;
	
	public InvoiceDocument() {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Date getInvoiceDate() {
		return invoice_date;
	}

	public void setInvoiceDate(Date invoice_date) {
		this.invoice_date = invoice_date;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

}