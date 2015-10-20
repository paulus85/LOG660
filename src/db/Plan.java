package db;

import javax.persistence.*;

@Entity
@Table(name="PLAN")
public class Plan {
	
	private Integer planID;
	private String name;
	private Integer cost;
	private Integer maxDuration;
	private Integer maxLocation;
	
	public Plan() {
		
	}
	
	public Plan(Integer planId, String name, Integer cost, Integer maxDuration, Integer maxLocation) {
		this.planID = planId;
		this.name = name;
		this.cost = cost;
		this.maxDuration = maxDuration;
		this.maxLocation = maxLocation;
	}
	
	@Id
	@Column(name="PLANID")
	public Integer getPlanID() {
		return planID;
	}
	
	public void setPlanID(Integer planID) {
		this.planID = planID;
	}
	
	@Column(name="NAME", length=100)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="COST")
	public Integer getCost() {
		return cost;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	@Column(name="MAXDURATION")
	public Integer getMaxDuration() {
		return maxDuration;
	}
	
	public void setMaxDuration(Integer maxDuration) {
		this.maxDuration = maxDuration;
	}
	
	@Column(name="MAXLOCATION")
	public Integer getMaxLocation() {
		return maxLocation;
	}
	
	public void setMaxLocation(Integer maxLocation) {
		this.maxLocation = maxLocation;
	}

}
