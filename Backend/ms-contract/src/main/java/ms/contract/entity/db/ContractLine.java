package ms.contract.entity.db;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contractline")
public class ContractLine {
	
	@Id
	@Column(name = "phone", updatable = false, nullable = false)
	private String phone;
	
	@Column(name = "rate")
	private String rate;
	
	@Column(name = "contract_type")
	private String contractType;
	
	@Column(name = "iccid")
	private String iccid;
	
	@Column(name = "pin")
	private String pin;
	
	@Column(name = "puk")
	private String puk;
	
	@Column(name = "tecnology")
	private String tecnology;
	
	@Column(name = "partner_points")
	private Integer partnerPoints;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "contract_id")
	private Contract contract;
	
	@OneToOne
	@JoinColumn(name = "phone")
	private LineConsumption lineConsumption;
	
	@OneToOne
	@JoinColumn(name = "phone")
	private DataConsumption dataConsumption;
	
	@OneToMany(mappedBy="contractLine", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ContractServices> contractServices;

	public ContractLine() {

	}

	public String getRate() {
		return rate;
	}
	
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPuk() {
		return puk;
	}

	public void setPuk(String puk) {
		this.puk = puk;
	}

	public String getTecnology() {
		return tecnology;
	}

	public void setTecnology(String tecnology) {
		this.tecnology = tecnology;
	}

	public Integer getPartnerPoints() {
		return partnerPoints;
	}

	public void setPartnerPoints(Integer partnerPoints) {
		this.partnerPoints = partnerPoints;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public LineConsumption getLineConsumption() {
		return lineConsumption;
	}

	public void setLineConsumption(LineConsumption lineConsumption) {
		this.lineConsumption = lineConsumption;
	}

	public DataConsumption getDataConsumption() {
		return dataConsumption;
	}

	public void setDataConsumption(DataConsumption dataConsumption) {
		this.dataConsumption = dataConsumption;
	}

	public List<ContractServices> getContractServices() {
		return contractServices;
	}

	public void setContractServices(List<ContractServices> contractServices) {
		this.contractServices = contractServices;
	}

}