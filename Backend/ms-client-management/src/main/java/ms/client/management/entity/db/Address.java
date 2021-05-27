package ms.client.management.entity.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	private Long id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "direction")
	private String direction;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "stairs")
	private String stairs;
	
	@Column(name = "floor")
	private String floor;
	
	@Column(name = "door")
	private String door;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "country")
	private String country;
	
	public Address() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStairs() {
		return stairs;
	}

	public void setStairs(String stairs) {
		this.stairs = stairs;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}