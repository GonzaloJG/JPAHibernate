package centripio.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import centripio.ecommerce.entity.Customer;

public class Querys {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		//JPQL = Java Persistence Query Language
		//Query query = em.createQuery("SELECT e FROM Customer e where e.fistname= :fistname ");
		Query query = em.createQuery("SELECT e FROM Customer e where e.fistname= :fistname", Customer.class);
		query.setParameter("fistname", "Juan");
		List<Customer> customers = query.getResultList();
		
		for (Customer current: customers) {
			System.out.println(current.getFistname());
		}
		
	}
}
