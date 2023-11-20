package centripio.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;

import centripio.ecommerce.dto.OrderTotalDTO;
import centripio.ecommerce.entity.Order;

public class JPQL {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
	
		/*
		em.createQuery("SELECT ABS(o.total) FROM Order o")
				.getResultStream()
				.forEach(System.out::println);
		*/
		
		/*
		String name = "oscar";
		em.createQuery("SELECT o FROM Order o WHERE o.customer.fistname LIKE :name", Order.class)
		.setParameter("name", "%"+ name + "%")
		.getResultStream()
		.forEach(x -> System.out.println(x.getId()));
		*/
		/*
		em.createQuery("SELECT TRIM(o.customer.fistname) FROM Order o", String.class)
		.getResultStream()
		.forEach(System.out::println);
		*/
		/*
		em.createQuery("SELECT o FROM Order o WHERE o.lines IS NOT EMPTY", Order.class)
			.getResultStream()
			.forEach(x -> System.out.println(x.getId()));
		*/
		/*
		em.createQuery("SELECT o.id as id, size(o.lines) as size FROM Order o", Tuple.class)
		.getResultStream()
		.forEach(x -> System.out.println(x.get("id") + ", "+ x.get("size")));
		*/
		/*
		em.createQuery("SELECT o FROM Order o WHERE o.id = :id or o.total > 100 AND UPPER(o.customer.fistname) <> :name", Order.class)
		.setParameter("id", 1L)
		.setParameter("name", "rene")
		.getResultStream()
		.forEach(x -> System.out.println(x.getCustomer().getFistname()));
		*/
		/*
		em.createQuery("SELECT o FROM Order o where o.total between :start AND :end", Order.class)
		.setParameter("start", 100d)
		.setParameter("end", 4000d)
		.getResultStream()
		.forEach(x-> System.out.println(x.getId()));
		*/
		
		List<OrderTotalDTO> results = em.createQuery("SELECT new centripio.ecommerce.dto.OrderTotalDTO(o.customer.fistname as name, sum(o.total) as total) FROM Order o GROUP BY o.customer.fistname", OrderTotalDTO.class)
					.getResultList();
		
		for (OrderTotalDTO row: results) {
			System.out.println(row.getName() + " " + row.getTotal());
		}
	}
}
