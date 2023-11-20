package centripio.ecommerce;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Dates {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.createQuery("SELECT YEAR(c.regDate) FROM Customer c WHERE e.regDate > :regDate")
		.setParameter("regDate", Calendar.getInstance(), TemporalType.TIMESTAMP)
			.getResultList()
			.forEach(x -> System.out.println(ReflectionToStringBuilder.toString(x, ToStringStyle.MULTI_LINE_STYLE)));
	}
}
