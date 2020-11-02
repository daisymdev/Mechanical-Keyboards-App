package entity;

public class Cases {
	
	private int caseId; 
	private String material;
	private int sizePercentage;
	
	//constructor
	public Cases(int caseId, String material, int sizePercentage) {
		this.setCaseId(caseId);
		this.setMaterial(material); 
		this.setSizePercentage(sizePercentage);
	}

	public int getCaseId() {
		return caseId;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getSizePercentage() {
		return sizePercentage;
	}

	public void setSizePercentage(int sizePercentage) {
		this.sizePercentage = sizePercentage;
	}

}
