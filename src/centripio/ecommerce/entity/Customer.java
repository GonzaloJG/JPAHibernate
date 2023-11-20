package centripio.ecommerce.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import centripio.ecommerce.enums.CustomerStatus;


@Entity
@Table(name="customers")
//@SequenceGenerator(name="customer_sec", sequenceName = "customer_sec", initialValue = 1, allocationSize = 1)
public class Customer {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sec")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="fistname", length = 30, nullable = false)
	private String fistname;
	
	@Column(name="lastname", length = 50, nullable = false)
	private String lastname;
	
	@Transient
	private String fullname;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="birthday", nullable = false)
	private LocalDate birthday;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_date", nullable = false, updatable = false)
	private Calendar regDate = Calendar.getInstance();
	
	/*
	@Column(name="time_at", nullable = false, updatable = false)
	private LocalTime time = LocalTime.now();
	*/
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable = false, length = 8)
	private CustomerStatus status = CustomerStatus.ACTIVE;
	
	@Embedded
	private Image avatar;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFistname() {
		return fistname;
	}
	public void setFistname(String fistname) {
		this.fistname = fistname;
		setFullname(fistname + " " + this.lastname);
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
		setFullname(this.fistname + " " + lastname);
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Calendar getRegDate() {
		return regDate;
	}
	public void setRegDate(Calendar regDate) {
		this.regDate = regDate;
	}
	/*
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}*/
	public CustomerStatus getStatus() {
		return status;
	}
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	private String getFullname() {
		return fullname;
	}
	 void setFullname(String fullname) {
		this.fullname = fullname;
	}
	 
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}
	public Image getAvatar() {
		return avatar;
	}
	public void setAvatar(Image avatar) {
		this.avatar = avatar;
	}
	
	
	
}
