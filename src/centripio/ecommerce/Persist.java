package centripio.ecommerce;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.enums.CustomerStatus;

public class Persist {

	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Customer customer1 = new Customer();
		customer1.setBirthday(LocalDate.now());
		customer1.setFistname("Ramón");
		customer1.setLastname("Lopez");
		customer1.setStatus(CustomerStatus.ACTIVE);
		
		em.persist(customer1);
		System.out.println("id => "+ customer1.getId());
		
		Customer customer2 = new Customer();
		customer2.setBirthday(LocalDate.now());
		customer2.setFistname("Ramón");
		customer2.setLastname("Lopez");
		customer2.setStatus(CustomerStatus.ACTIVE);
		
		em.persist(customer2);
		
		em.getTransaction().commit();
	}
}
