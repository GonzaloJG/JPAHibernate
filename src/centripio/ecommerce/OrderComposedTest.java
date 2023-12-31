package centripio.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.entity.OrderComposed;
import centripio.ecommerce.entity.OrderPk;

public class OrderComposedTest {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer = em.find(Customer.class, 1L);
		
		OrderPk pk = new OrderPk("A", 1L);
		OrderComposed order = new OrderComposed();
		order.setId(pk);
		order.setCustomer(customer);
		
		em.persist(order);
		
		em.getTransaction().commit();
		
		//OrderPK pk = new OrderPK("A", 1L);
		//OrderComposed savedOrder = em.find(OrderComposed.class, pk);
		//System.out.println(savedOrder.getSerie());
	}
}
