package ms.contract.entity.db;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract {
	
	@Id
	@Column(name = "document", updatable = false, nullable = false)
	private String document;
	
	@Column(name = "contract_name")
	private String contractName;
	
	@OneToMany(mappedBy="contract", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<ContractLine> contractLines;
	
	public Contract() {

	}
	
	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public List<ContractLine> getContractLines() {
		return contractLines;
	}

	public void setContractLines(List<ContractLine> contractLines) {
		this.contractLines = contractLines;
	}

}