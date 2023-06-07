package hibernateOneToOne.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PanCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// identity is not perform post increment it will insert directly data not create extra column
	
	private int id ;
	private String name;
	private String email ;
	private long phone ;
	private String panNum;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
	
	@Override
	public String toString() {
		return "PanCard [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", panNum=" + panNum
				+ "]";
	}
	
	public PanCard( String name, String email, long phone, String panNum) {
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.panNum = panNum;
	}
	
	
	public PanCard() {
		super();
	}
	
	

}
