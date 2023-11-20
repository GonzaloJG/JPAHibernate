package centripio.ecommerce;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.enums.CustomerStatus;


public class Update {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer1 = em.find(Customer.class, 1L);
		customer1.setFistname("Rebeca");
		customer1.setLastname("Iturralde");
		
		em.persist(customer1);
		
		em.getTransaction().commit();
		
		
		em.getTransaction().begin();
		Customer customer2 = new Customer();
		customer1.setId(1L);
		customer2.setFistname("Oscar");
		customer2.setLastname("Blancarte");
		customer2.setBirthday(LocalDate.now());
		customer2.setStatus(CustomerStatus.ACTIVE);
		em.merge(customer2);
		
		em.getTransaction().commit();
	}
}
