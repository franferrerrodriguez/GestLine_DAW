package ms.authentication.entity;

public class Client {

	private String document;
	private String documentType;
	private String clientType;
	private String name;
	private String firstSurname;
	private String secondSurname;
	private String birthDate;
	private String email;
	private Boolean onlineInvoice;
	private Integer due;
	private Integer limitDue;
	private Boolean blacklist;
	private Address address;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
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