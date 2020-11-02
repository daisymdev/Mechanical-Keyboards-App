package entity;

import java.util.List;

public class Cases {
	
	private int caseId; 
	private String material;
	private List<Switches> switches;
	
	//constructor
	public Cases(int caseId, String material, List<Switches> switches) {
		this.setCaseId(caseId);
		this.setMaterial(material); 
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

//	public int getSizePercentage() {
//		return sizePercentage;
//	}
//
//	public void setSizePercentage(int sizePercentage) {
//		this.sizePercentage = sizePercentage;
//	}


	public List<Switches> getSwitches() {
		return switches;
	}


	public void setSwitches(List<Switches> switches) {
		this.switches = switches;
	}

}
