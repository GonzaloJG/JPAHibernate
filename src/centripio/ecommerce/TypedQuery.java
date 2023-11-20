package centripio.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Tuple;

import centripio.ecommerce.entity.Order;

public class TypedQuery {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		/*
		Query query = em.createQuery("SELECT o FROM Order o WHERE o.id = :id");
		query.setParameter("id", 1L);
		List<Order> orders = (List<Order>) query.getResultList();
		orders.stream().forEach( x -> System.out.println(x.getId()));
		*/
		
		/*
		Query query = em.createQuery("SELECT o FROM Order o WHERE o.id = :id");
		query.setParameter("id", 10L);
		Order order = (Order) query.getSingleResult();
		System.out.println(order.getId());
		*/
		/*
		em.createQuery("SELECT o FROM Order o WHERE o.id = :id and size(o.lines) > :lines", Order.class)
			.setParameter("id", 1L)
			.setParameter("lines", 0)
			.setHint("hint1", 1)
			.setFirstResult(10)
			.setMaxResults(10)
			.getResultList()
			.stream()
			.forEach(x -> System.out.println(x.getId()));
		
		Order order = em.createQuery("SELECT o FROM Order o", Order.class)
				.getSingleResult();
		*/
		/*
		List<Object[]> results = em.createQuery("SELECT o.id, o.total FROM Order o")
				.getResultList();
		
		for (Object[] row: results) {
			System.out.println(row[0] + ", " + row[1]);
		}
		*/
		
		List<Tuple> results = em.createQuery("SELECT o.id as id, o.total as total FROM Order o", Tuple.class)
			.getResultList();
		
		for (Tuple row: results) {
			System.out.println(row.get("id") + ", " + row.get("total"));
		}
		
		Object result = em.createNativeQuery("SELECT now()")
				.getSingleResult();
		
		System.out.println(result.toString());
		
	}
}
