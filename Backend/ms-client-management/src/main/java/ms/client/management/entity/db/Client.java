package ms.client.management.entity.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@Column(name = "document")
	private String document;
	
	@Column(name = "document_type")
	private String documentType;
	
	@Column(name = "client_type")
	private String clientType;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "first_surname")
	private String firstSurname;
	
	@Column(name = "second_surname")
	private String secondSurname;
	
	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "online_invoice")
	private Boolean onlineInvoice;
	
	@Column(name = "due")
	private Integer due;
	
	@Column(name = "limit_due")
	private Integer limitDue;
	
	@Column(name = "blacklist")
	private Boolean blacklist;

	@OneToOne()
    @JoinColumn(name = "address")
	private Address address;
	
	@OneToOne()
	@JoinColumn(name = "billing")
	private Billing billing;

	public Client() {

	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getOnlineInvoice() {
		return onlineInvoice;
	}

	public void setOnlineInvoice(Boolean onlineInvoice) {
		this.onlineInvoice = onlineInvoice;
	}

	public Integer getDue() {
		return due;
	}

	public void setDue(Integer due) {
		this.due = due;
	}

	public Integer getLimitDue() {
		return limitDue;
	}
	
	public void setLimitDue(Integer limitDue) {
		this.limitDue = limitDue;
	}

	public Boolean getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(Boolean blacklist) {
		this.blacklist = blacklist;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

}