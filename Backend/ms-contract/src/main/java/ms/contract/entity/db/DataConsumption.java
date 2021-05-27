package ms.contract.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dataconsumption")
public class DataConsumption {
	
	@Id
	@JsonIgnore
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "total_bytes")
	private Double totalBytes;
	
	@Column(name = "total_bytes_international")
	private Double totalBytesInternational;
	
	@Column(name = "total_bytes_bonus")
	private Double totalBytesBonus;
	
	@Column(name = "usage_bytes")
	private Double usageBytes;
	
	@Column(name = "usage_bytes_international")
	private Double usageBytesInternational;
	
	@Column(name = "usage_bytes_bonus")
	private Double usageBytesBonus;
	
	public DataConsumption() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Double getTotalBytes() {
		return totalBytes;
	}
	
	public void setTotalBytes(Double totalBytes) {
		this.totalBytes = totalBytes;
	}
	
	public Double getTotalBytesInternational() {
		return totalBytesInternational;
	}
	
	public void setTotalBytesInternational(Double totalBytesInternational) {
		this.totalBytesInternational = totalBytesInternational;
	}
	
	public Double getTotalBytesBonus() {
		return totalBytesBonus;
	}
	
	public void setTotalBytesBonus(Double totalBytesBonus) {
		this.totalBytesBonus = totalBytesBonus;
	}
	
	public Double getUsageBytes() {
		return usageBytes;
	}
	
	public void setUsageBytes(Double usageBytes) {
		this.usageBytes = usageBytes;
	}
	
	public Double getUsageBytesInternational() {
		return usageBytesInternational;
	}
	
	public void setUsageBytesInternational(Double usageBytesInternational) {
		this.usageBytesInternational = usageBytesInternational;
	}

	public Double getUsageBytesBonus() {
		return usageBytesBonus;
	}

	public void setUsageBytesBonus(Double usageBytesBonus) {
		this.usageBytesBonus = usageBytesBonus;
	}
	
}