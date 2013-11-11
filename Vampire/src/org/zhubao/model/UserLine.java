/**
 * 
 */
package org.zhubao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jason.Zhu
 * @date   2013-11-11
 * @email jasonzhu@augmentum.com.cn
 */
@Entity
@Table(name = "v_userline")
public class UserLine {

	private long id;
	private String name;
	private String email;
	private String message;
	private Date creatdDate;
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatdDate() {
		return creatdDate;
	}
	public void setCreatdDate(Date creatdDate) {
		this.creatdDate = creatdDate;
	}
	@Override
	public String toString() {
		return "UserLine [id=" + id + ", name=" + name + ", email=" + email
				+ ", message=" + message + ", creatdDate=" + creatdDate + "]";
	}
	
	
	
	
}
