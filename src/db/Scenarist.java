package db;

import javax.persistence.*;

@Entity
@Table(name="SCENARIST")
public class Scenarist {
	
	private Integer scenaristId;
	private String name;
	
	public Scenarist(){
		
	}
	
	public Scenarist(String name) {
		this.name = name;
	}

	@Id
	@SequenceGenerator(name = "scenaristSeq", sequenceName="SCENARISTSEQ", allocationSize=1)
	@GeneratedValue(generator="scenaristSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="SCENARISTID")
	public Integer getScenaristId() {
		return scenaristId;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setScenaristId(Integer scenaristId) {
		this.scenaristId = scenaristId;
	}

	public void setName(String name) {
		this.name = name;
	}

}
