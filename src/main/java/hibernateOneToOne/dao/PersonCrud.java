package hibernateOneToOne.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernateOneToOne.dto.PanCard;
import hibernateOneToOne.dto.Person;


public class PersonCrud {

	
	
	
	public EntityManager getmanager()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
		EntityManager manager= factory.createEntityManager();
		return manager;
		
	}
	
	
	public void savePerson(Person person , int cardid  )
	{
		// we are saving person type of object so we taken personCrud parameter 
		//pancard needed for mapping
		EntityManager manager = getmanager();
		
		PanCard card = manager.find(PanCard.class,cardid);
		
		if (card != null) {
			person.setCard(card);
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(person);
			transaction.commit();
			
		}
		else {
		System.out.println("provid valid pan numnber ");
		}
		
	}
	
	
	
	public void deletePerson(int  id)
	{
		EntityManager manager=getmanager();
		Person person = manager.find(Person.class,id);
		
		 if (person != null) {
			 EntityTransaction transaction = manager.getTransaction();
			 transaction.begin();
			 manager.remove(person);

			 transaction.commit();
			 System.out.println("person deleted ");
		}
		 else {
			System.out.println("your id is not exist to delete : ");
		}
		
	}
	
	public void updateperson(int id )
	{
		EntityManager manager = getmanager();
		PersonCrud dbcard = manager.find(PersonCrud.class, manager); //
		System.out.println(dbcard);
	}
	
	
	public void getPersonById(int id)
	
	{
		EntityManager manager=getmanager();
		Person person=manager.find(Person.class, id);
		if (person != null) 
		{
			
		System.out.println(person);
			
		 }
			
			else {
				System.out.println("you enter wrong id : "+id);
			
		}
	}
}
