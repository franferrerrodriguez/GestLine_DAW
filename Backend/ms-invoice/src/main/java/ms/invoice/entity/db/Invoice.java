package ms.invoice.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "invoice")
public class Invoice {
	
	@Id
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name = "invoice_document")
	@JsonIgnore
	private InvoiceDocument invoiceDocument;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "tax")
	private Double tax;
	
	@Column(name = "tax_amount")
	private Double taxAmount;
	
	@Column(name = "total_amount")
	private Double totalAmount;

	public Invoice() {

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInvoiceDocument(InvoiceDocument invoiceDocument) {
		this.invoiceDocument = invoiceDocument;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}