package domain.entity;

public class Property {
	private int id;
	private int active;
	private String description;
	private String AdditionalInfo;
	private String Address;
	private int ownerId;
	
	public Property() {}
	
	public Property(int id, int active, String description, String additionalInfo, String address, int ownerId) {
		super();
		this.id = id;
		this.active = active;
		this.description = description;
		AdditionalInfo = additionalInfo;
		Address = address;
		this.ownerId = ownerId;
	}
	
	public Property(int id, String description, String additionalInfo) {
		super();
		this.id = id;
		this.description = description;
		AdditionalInfo = additionalInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdditionalInfo() {
		return AdditionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		AdditionalInfo = additionalInfo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", active=" + active + ", description=" + description + ", AdditionalInfo="
				+ AdditionalInfo + ", Address=" + Address + ", ownerId=" + ownerId + "]";
	}
}
