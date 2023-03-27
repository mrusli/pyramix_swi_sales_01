package com.pyramix.domain.common;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class IdBasedObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3349832353453828283L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id = Long.MIN_VALUE;
	
	@Column(name = "version")
	private Integer version = 1;
	
	//  `create_date` datetime DEFAULT NULL,
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	//  `last_edit_date` datetime DEFAULT NULL,
	@Column(name = "last_edit_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastEditDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
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
		IdBasedObject other = (IdBasedObject) obj;
		return Objects.equals(id, other.id);
	}
}
