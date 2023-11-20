package centripio.ecommerce.entity;

import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class EntityAudit {

	@PreUpdate
	private void preUpdate(Object obj) {
		System.out.println("preUpdate > " + ReflectionToStringBuilder.toString(obj, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	@PostUpdate
	private void postUpdate(Object obj) {
		System.out.println("postUpdate > " + ReflectionToStringBuilder.toString(obj, ToStringStyle.MULTI_LINE_STYLE));
	}
}
