package centripio.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Order;
import centripio.ecommerce.entity.OrderLine;

public class OrderBy {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		Order order = em.find(Order.class, 1L);
		List<OrderLine> lines = order.getLines();
		
		for (OrderLine line: lines) {
			System.out.println(line.getCtr());
		}
	}
}
