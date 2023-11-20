package centripio.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import centripio.ecommerce.enums.Status;

@Entity
@Table(name="orders_composed")
//@IdClass(OrderPk.class)
public class OrderComposed {

	////////////////////////
	@EmbeddedId
	private OrderPk id;
	
	//////////////////////
	//@Id
	//@Column(name="serie")
	//private String serie;
	
	//@Id
	//@Column(name="folio")
	//private Long folio;
	//////////////////////
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_customer", nullable = false, updatable = false)
	private Customer customer;
	
	@Column(name="reg_date", nullable = false, updatable = false)
	private LocalDateTime regDate = LocalDateTime.now();
	
	@Column(name="status", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVE;
	
	
	public OrderPk getId() {
		return id;
	}

	public void setId(OrderPk id) {
		this.id = id;
	}
	
	

	public Customer getCustomer() {
		return customer;
	}

	/*public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Long getFolio() {
		return folio;
	}

	public void setFolio(Long folio) {
		this.folio = folio;
	}*/

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
