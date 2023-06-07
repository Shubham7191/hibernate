package hibernateOneToOne.controller;

import java.util.Scanner;



import hibernateOneToOne.dao.PanCardCrud;
import hibernateOneToOne.dao.PersonCrud;
import hibernateOneToOne.dto.PanCard;
import hibernateOneToOne.dto.Person;


public class PersonPanCardMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		
		PanCardCrud crud = new PanCardCrud();
		PersonCrud crud2 = new PersonCrud();
		
		Scanner sc = new Scanner(System.in);
		boolean check = true ;
		do {
			
			System.out.println("choose option \n 1 save panCard  \n 2  save person \n 3 update_Card \n 4 delete_Card  \n 5 delete_person  \n 6 getPan \n 7 get_Person");
			int choose= sc.nextInt();
			
			switch (choose ) {
			case 1:{
				
				System.out.println("enter your name  to  save :");
				String name = sc.next();
				
				System.out.println("enter your email : ");
				String email = sc.next();
				System.out.println("enter your phone :");
				long phone = sc.nextLong();
				 System.out.println("enter your pan number :");
				 String pannum = sc.next();
				 PanCard card = new PanCard(name, email, phone, pannum);
				
				 crud.savePanCard(card);
				 
			}break;
				case 2: {
					System.out.println("enter your name ");
					String name = sc.next();
					System.out.println("enter your email ");
					String email = sc.next();
					System.out.println("enter your phone number :");
					long phone = sc.nextLong();
					System.out.println("enter your adress");
					String address = sc.next();
					
					System.out.println("enter your pan card id :");
					int cardid = sc.nextInt();
					
				Person person = new Person(name, email, phone, address);
				crud2.savePerson(person, cardid);
				
				
					
				} break;
				case 3:{
					// this also we can do previous we are initialize by using constructor and now we are set value by useing setter method
					
					System.out.println("enter your id");
				    int id=sc.nextInt();
					System.out.println("enter your name");
					String name=sc.next();
					
					System.out.println("enter your phone");
					long phone=sc.nextLong();
					
					
					PanCard card=new PanCard();
					
					// to perform and setter and initialize value we create object and that's we in panCard we create no argument type constructor  
					
					card.setName(name);
					card.setPhone(phone);
					
					crud.updateCard(id, card);
					
					
					
					
				}break;
				
				
				case 4:{
					System.out.println("enter your id");
			         int id=sc.nextInt();
			     	PanCard card=new PanCard();
			     card.setId(id);
			     	crud.deleteCard(id);
			       
					
				}break;
				
				
				
				case 5 :{
					
					System.out.println("enter your id");
			         int id=sc.nextInt();

			    
			         Person person= new Person();
			         person.setId(id);
			         crud2.deletePerson(id);
			         
					
					
				} break;
				
				case 6:
				{
					crud.getPanCardById(1);
					
					
				}break;
				
				case 7:
				{
					crud2.getPersonById(2);
				}
				break;
			default:
				break;
			}
			
			
		} while (check);
		
	}
}
