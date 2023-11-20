package centripio.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import centripio.ecommerce.enums.Status;

@Entity
@Table(name="products")
@NamedQueries(value = {
		@NamedQuery(name="Product.findByName", query="select p from Product p where UPPER(p.name) = UPPER(:name)")
})
@EntityListeners(EntityAudit.class)
public class Product {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", length = 100, nullable = false)
	private String name;
	
	@Column(name="price", nullable = false)
	private Double price = 0d;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable = false, length = 10)
	private Status status=Status.ACTIVE;
	
	@Column(name="reg_date", nullable = false, updatable = false)
	private LocalDateTime regDate = LocalDateTime.now();
	
	@Embedded
	private Image image;
	
	@ManyToMany
	@JoinTable(name="rel_prod_clas", 
	joinColumns = {@JoinColumn(name="fk_product")}, 
	inverseJoinColumns = {@JoinColumn(name="fk_clasification")} )
	private List<Clasification> clasification;
	
	@Version
	private Long version;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public List<Clasification> getClasification() {
		if(this.clasification == null) {
			this.clasification = new ArrayList<Clasification>();
		}
		return clasification;
	}

	public void setClasification(List<Clasification> clasification) {
		this.clasification = clasification;
	}
	
	public void addClasification(Clasification clasification) {
		List<Clasification> Clasifications = getClasification();
		Clasifications.add(clasification);	
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	/*
	@PreUpdate
	private void preUpdate() {
		System.out.println("preUpdate > " + ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	@PostUpdate
	private void postUpdate() {
		System.out.println("postUpdate > " + ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE));
	}*/
}
