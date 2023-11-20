package centripio.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.entity.Order;
import centripio.ecommerce.entity.OrderLine;

public class OneToMany {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
	
		em.getTransaction().begin();
		
		Customer customer1 = em.find(Customer.class, 1L);
		
		Order order = new Order();
		order.setCustomer(customer1);
		
		em.persist(order);
		
		for (int c = 0; c < 10; c++) {
			OrderLine line = new OrderLine();
			//line.setProduct("Product" + (c+1));
			line.setQuantity(c+1d);
			line.setUnitPrice((c+1)*10d);
			order.addLines(line);
			
			em.persist(line);
		}
		
		em.persist(order);
		
		em.getTransaction().commit();
		
		em.detach(order);
		
		Order order1 = em.find(Order.class, 1L);
		
		for (OrderLine line: order1.getLines()) {
			System.out.println("Product => " + line.getProduct());
		}
		
	}
}
