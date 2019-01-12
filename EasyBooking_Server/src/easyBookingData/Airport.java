package easyBookingData;

public class Airport {
	
	private String code;
	private String name;
	private int commision;
	
	
	public Airport(String code, String name, int commision) {
		this.code = code;
		this.name = name;
		this.commision = commision;
	}
	
	 public String getCode() {
			return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCommision() {
		return commision;
	}

	public void setCommision(int commision) {
		this.commision = commision;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}
