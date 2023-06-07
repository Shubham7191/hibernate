package hibernateOneToOne.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id ;
		private String name ;
		private String email ;
		private long phone ;
		private String address ;
		
		@OneToOne
		private PanCard card;

		
		
		
		
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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public PanCard getCard() {
			return card;
		}

		public void setCard(PanCard card) {
			this.card = card;
		}

//		@Override
//		public String toString() {
//			return "person [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
//					+ address + ", card=" + card + "]";
//			
//			
//			
//			//we want value so we override without overriding we get object address not data/value
//		}

		public Person(String name, String email, long phone, String address) {
			super();
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.address = address;
			
		}
		
		
		
		public Person() {
			super();
		}
		
		
		
}


//fetchtype by default is eager type thats why even we comment toString we get both side data