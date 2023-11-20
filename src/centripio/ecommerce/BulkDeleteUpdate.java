package centripio.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.omg.PortableInterceptor.INACTIVE;

import centripio.ecommerce.entity.Order;
import centripio.ecommerce.enums.Status;

public class BulkDeleteUpdate {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		/*
		List<Order> orders = em.createQuery("SELECT o FROM Order o", Order.class)
			.getResultList();
		
		for (Order order: orders) {
			order.setTotal(1000d);
			em.persist(order);
		}
		*/
		
		int updates = em.createQuery("update Order set total = total + :total, status= :status")
			.setParameter("total", 1000d)
			.setParameter("status", Status.INACTIVE)
			.executeUpdate();
		System.out.println("update => " + updates);
		
		/*
		int deleteLines = em.createQuery("delete from OrderLine")
				.executeUpdate();
			System.out.println("delete => " + deleteLines);
			
		int deletes = em.createQuery("delete from Order")
				.executeUpdate();
			System.out.println("delete => " + deletes);
		*/
		em.getTransaction().commit();
		
		
	}
}
