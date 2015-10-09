package db;

public class Plan {
	
	private Integer planID;
	private String name;
	private Integer cost;
	private Integer maxDuration;
	private Integer maxLocation;
	
	public Plan() {
		
	}
	
	public Plan(Integer planID, String name, Integer cost, Integer maxDuration, Integer maxLocation) {
		this.planID = planID;
		this.name = name;
		this.cost = cost;
		this.maxDuration = maxDuration;
		this.maxLocation = maxLocation;
	}
	
	public Integer getPlanID() {
		return planID;
	}
	
	public void setPlanID(Integer planID) {
		this.planID = planID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCost() {
		return cost;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	public Integer getMaxDuration() {
		return maxDuration;
	}
	
	public void setMaxDuration(Integer maxDuration) {
		this.maxDuration = maxDuration;
	}
	
	public Integer getMaxLocation() {
		return maxLocation;
	}
	
	public void setMaxLocation(Integer maxLocation) {
		this.maxLocation = maxLocation;
	}

}
