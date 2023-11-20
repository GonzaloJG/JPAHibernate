package centripio.ecommerce;

import java.io.InputStream;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import centripio.ecommerce.entity.Customer;
import centripio.ecommerce.entity.Image;
import centripio.ecommerce.entity.Product;

public class Binarios {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		try(InputStream stream = Binarios.class.getClassLoader().getResourceAsStream("META-INF/galletas.jpg")) {
			int fileLength = stream.available();
			byte[] bytes = new byte[stream.available()];
			System.out.println("bytes > " + stream.available());
			stream.read(bytes);
			
			Image image = new Image();
			image.setImage(bytes);
			image.setLength((long)fileLength);
			image.setName("galletas.jpg");
			image.setType("/image/jpeg");
			
			Product product = new Product();
			product.setImage(image);
			product.setName("Producto con Imagen");
			product.setPrice(100d);
			
			em.persist(product);
			
			
			Customer customer = new Customer();
			customer.setAvatar(image);
			customer.setFistname("Manuel");
			customer.setLastname("Lopez");
			customer.setBirthday(LocalDate.now());
			em.persist(customer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		em.getTransaction().commit();
		/*
		Product productoImagen = em.createNamedQuery("Product.findByName", Product.class)
			.setParameter("name", "Producto con Imagen")
			.getSingleResult();
		*/
		
		//System.out.println(productoImagen.getId() + ", " + productoImagen.getImage());
		
	}
}
