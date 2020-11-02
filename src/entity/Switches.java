package entity;

public class Switches {
	
	private int switchesId;
	private String name; 
	
	public Switches(int switchesId, String name) {
		this.setSwitchesId(switchesId);
		this.setName(name);
	}

	public int getSwitchesId() {
		return switchesId;
	}

	public void setSwitchesId(int switchesId) {
		this.switchesId = switchesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
