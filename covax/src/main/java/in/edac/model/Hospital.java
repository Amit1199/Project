package in.edac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hspId;
	
	@Column(nullable=false)
	private String hspName;
	
	@Column(nullable=false)
	private String hspEmailAdd;
	
	@Column(nullable=false)
	private String hspAdd;
	
	@Column(nullable=false)
	private int hspCNo;
	
	@Column(nullable=false)
	private int hspPin;
	
	@Column(nullable = false, unique = true)
	private String hspUsername;
	
	@Column(nullable = false, unique = true)
	private String hspPassword;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Hospital(String hspName, String hspEmailAdd, String hspAdd, int hspCNo, int hspPin, String hspUsername,
			String hspPassword) {
		super();
		this.hspName = hspName;
		this.hspEmailAdd = hspEmailAdd;
		this.hspAdd = hspAdd;
		this.hspCNo = hspCNo;
		this.hspPin = hspPin;
		this.hspUsername = hspUsername;
		this.hspPassword = hspPassword;
	}




	public int getHspId() {
		return hspId;
	}

	public void setHspId(int hspId) {
		this.hspId = hspId;
	}

	public String getHspName() {
		return hspName;
	}

	public void setHspName(String hspName) {
		this.hspName = hspName;
	}

	public String getHspAdd() {
		return hspAdd;
	}

	public void setHspAdd(String hspAdd) {
		this.hspAdd = hspAdd;
	}

	public int getHspCNo() {
		return hspCNo;
	}

	public void setHspCNo(int hspBNo) {
		this.hspCNo = hspBNo;
	}

	public String getHspUsername() {
		return hspUsername;
	}

	public void setHspUsername(String hspUsername) {
		this.hspUsername = hspUsername;
	}

	public String getHspPassword() {
		return hspPassword;
	}

	public void setHspPassword(String hspPassword) {
		this.hspPassword = hspPassword;
	}


	public int getHspPin() {
		return hspPin;
	}



	public void setHspPin(int hspPin) {
		this.hspPin = hspPin;
	}




	public String getHspEmailAdd() {
		return hspEmailAdd;
	}




	public void setHspEmailAdd(String hspEmailAdd) {
		this.hspEmailAdd = hspEmailAdd;
	}

	
	
}
