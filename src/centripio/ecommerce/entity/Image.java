package centripio.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class Image {

	@Lob
	@Column(name = "file_image")
	private byte[] image;
	
	@Column(name="file_name", length = 100)
	private String name;
	
	@Column(name="file_type", length = 30)
	private String type;
	
	@Column(name="file_length")
	private Long length;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
	
	
}
