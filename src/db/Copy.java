package db;

public class Copy {

	private Integer copyId;
	private boolean rented;
	private Integer filmId;
	
	public Copy() {
		
	}

	public Copy(Integer copyId, boolean rented, Integer filmId) {
		this.copyId = copyId;
		this.rented = rented;
		this.filmId = filmId;
	}

	public Integer getCopyId() {
		return copyId;
	}

	public void setCopyId(Integer copyId) {
		this.copyId = copyId;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}
	
	
}
