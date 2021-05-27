package ms.contract.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "lineconsumption")
public class LineConsumption {
	
	@Id
	@JsonIgnore
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@Column(name = "total_minuts")
	private Double totalMinuts;
	
	@Column(name = "total_minuts_international")
	private Double totalMinutsInternational;
	
	@Column(name = "usage_minuts")
	private Double usageMinuts;
	
	@Column(name = "usage_minuts_international")
	private Double usageMinutsInternational;
	
	@Column(name = "total_sms")
	private Integer totalSms;
	
	@Column(name = "usage_sms")
	private Integer usageSms;
	
	public LineConsumption() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Double getTotalMinuts() {
		return totalMinuts;
	}
	
	public void setTotalMinuts(Double totalMinuts) {
		this.totalMinuts = totalMinuts;
	}
	
	public Double getTotalMinutsInternational() {
		return totalMinutsInternational;
	}
	
	public void setTotalMinutsInternational(Double totalMinutsInternational) {
		this.totalMinutsInternational = totalMinutsInternational;
	}
	
	public Double getUsageMinuts() {
		return usageMinuts;
	}
	
	public void setUsageMinuts(Double usageMinuts) {
		this.usageMinuts = usageMinuts;
	}
	
	public Double getUsageMinutsInternational() {
		return usageMinutsInternational;
	}
	
	public void setUsageMinutsInternational(Double usageMinutsInternational) {
		this.usageMinutsInternational = usageMinutsInternational;
	}
	
	public Integer getTotalSms() {
		return totalSms;
	}
	
	public void setTotalSms(Integer totalSms) {
		this.totalSms = totalSms;
	}
	
	public Integer getUsageSms() {
		return usageSms;
	}
	
	public void setUsageSms(Integer usageSms) {
		this.usageSms = usageSms;
	}
	
}