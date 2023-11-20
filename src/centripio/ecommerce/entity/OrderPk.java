package centripio.ecommerce.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrderPk implements Serializable {

	private String serie;
	private Long folio;
	
	public OrderPk() {
		super();
	}
	
	public OrderPk(String serie, Long folio) {
		super();
		this.serie = serie;
		this.folio = folio;
	}

	public String getSerie() {
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
	}
	@Override
	public int hashCode() {
		return Objects.hash(folio, serie);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderPk other = (OrderPk) obj;
		return Objects.equals(folio, other.folio) && Objects.equals(serie, other.serie);
	}
	
	
}
