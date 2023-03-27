package com.pyramix.domain.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.pyramix.domain.common.IdBasedObject;
import com.pyramix.domain.common.SchemaUtil;

@Entity
@Table(name = "auth_user", schema = SchemaUtil.SCHEMA_COMMON)
public class User extends IdBasedObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7663200087477288797L;

	//	`user_name` varchar(255) DEFAULT NULL,
	@Column(name="user_name")
	private String user_name;
	
	//	`real_name` varchar(255) DEFAULT NULL,
	@Column(name="real_name")
	private String real_name;
	
	//	`user_password` varchar(255) DEFAULT NULL,
	@Column(name="user_password")
	private String user_password;
	
	//	`email` varchar(255) DEFAULT NULL,
	@Column(name="email")
	private String email;
	
	//	`enabled` char(1) DEFAULT NULL,
	@Column(name="enabled")
	@Type(type="true_false")	
	private boolean enabled;
	
	// Use Set instead of List to avoid duplicate roles for one user
	@OneToMany(cascade={ CascadeType.ALL }, orphanRemoval=false, fetch=FetchType.EAGER)
	@JoinTable(
			name="auth_user_join_role",
			joinColumns = @JoinColumn(name="id_user"),
			inverseJoinColumns = @JoinColumn(name="id_role"))	
	private Set<UserRole> user_roles;

	@Override
	public String toString() {
		return "User [id=" + super.getId() + ", createDate=" + super.getCreateDate() + ", lastEditDate=" + super.getLastEditDate()
				+ ", user_name=" + user_name + ", real_name=" + real_name + ", user_password=" + user_password
				+ ", email=" + email + ", enabled=" + enabled + ", user_roles=" + user_roles + "]";
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUser_roles() {
		return user_roles;
	}

	public void setUser_roles(Set<UserRole> user_roles) {
		this.user_roles = user_roles;
	}
}
