package db;

import java.sql.Date;

public class RentalCharacteristics {
	
	private Integer userId;
	private Integer copyId;
	private Date date;
	
	public RentalCharacteristics() {

	}

	public RentalCharacteristics(Integer userId, Integer copyId, Date date) {
		this.userId = userId;
		this.copyId = copyId;
		this.date = date;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getCopyId() {
		return copyId;
	}
	
	public void setCopyId(Integer copyId) {
		this.copyId = copyId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

}
