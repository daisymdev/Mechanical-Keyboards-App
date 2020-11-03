package entity;

import java.util.List;

public class Cases {
	
	private int caseId; 
	private String material;
	private String sizePercentage;
	private List<Switches> switches;
	
	//constructor
	public Cases(int caseId, String material, String sizePercentage, List<Switches> switches) {
		this.setCaseId(caseId);
		this.setMaterial(material); 
		this.setSizePercentage(sizePercentage);
		this.setSwitches(switches);
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

	public String getSizePercentage() {
		return sizePercentage;
	}

	public void setSizePercentage(String sizePercentage2) {
		this.sizePercentage = sizePercentage2;
	}


	public List<Switches> getSwitches() {
		return switches;
	}


	public void setSwitches(List<Switches> switches) {
		this.switches = switches;
	}

}
