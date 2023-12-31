package centripio.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Product;

public class VersionTest {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Product product = new Product();
		product.setName("Producto versionado");
		product.setPrice(200d);
		em.persist(product);
		
		em.getTransaction().commit();
		
		try {			
			Thread.sleep(15000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		em.getTransaction().begin();
		
		Product productA = em.createNamedQuery("Product.findByName", Product.class)
				.setParameter("name", "Producto versionado")
				.getSingleResult();
		
		productA.setPrice(500d);
		
		em.getTransaction().commit();
	}
}
