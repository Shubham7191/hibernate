 package hibernateOneToOne.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import hibernateOneToOne.dto.PanCard;

public class PanCardCrud {
	
	
	public EntityManager getmanager()
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("shubham");
		EntityManager manager= factory.createEntityManager();
		return manager;
		
	}
	
	
	
	public void savePanCard(PanCard card )
	{
		
		EntityManager manager = getmanager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(card);
		transaction.commit();
		
		
	}
	
	
	

	public void updateCard(int id , PanCard card)
	{
		// we take PanCard object to get all attribute from PanCard class , we took pan id because to validate data
	
	
		
		EntityManager manager = getmanager();
		PanCard dbcard = manager.find(PanCard.class,id);
		
		// transaction is used to transfer data from application to database 
		if (dbcard != null) {
			dbcard.setName(card.getName());
			dbcard.setPhone(card.getPhone());
			
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(dbcard);
		transaction.commit();
		System.out.println("upated value is :");
		System.out.println(dbcard);
		
	}
	
		
		
	}
	
	
	
	public void deleteCard(int id)
	{
		// remove method accept object
		// we can not direct delete we need to use 
		
		EntityManager manager = getmanager();
		PanCard dbcard = manager.find(PanCard.class,id);
		
		if (dbcard != null) {
			
		
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			System.out.println(dbcard);
			manager.remove(dbcard);
			transaction.commit();
			System.out.println(" deleted ");
			
		}
		else {
			System.out.println("your id is not exist to delete  " + id );
		}
	}
	
	public void getPanCardById(int id )
	{
		EntityManager manager=getmanager();
		PanCard dbCard = manager.find(PanCard.class,id);
		 if (dbCard != null) {
			 System.out.println(dbCard);
			
		}
		 else {
			System.out.println("no user not found based on : " + id );
		}
		
	}
	
	
}
