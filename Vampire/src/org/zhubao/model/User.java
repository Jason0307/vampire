/**
 * 
 */
package org.zhubao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * @author Jason.Zhu
 * @date 2013-10-30
 * @email jasonzhu@augmentum.com.cn
 */
@Entity
@Table(name = "v_user")
public class User {

	private long userId;
	@Column(nullable = false)
	@NotNull
	private String fname;
	@Column(nullable = false)
	@NotNull
	private String lname;
	@Column(nullable = false)
	@NotNull
	private String phone;
	@Column(nullable = false)
	@NotNull
	private String address;
	@Column(nullable = false)
	@Email
	private String email;
	@Column(nullable = false)
	@NotNull
	private String pass;
	@Column(nullable = false)
	@NotNull
	private String qq;
	@Column(nullable = false)
	@NotNull
	private String weibo;
	@Column(nullable = false)
	private String facebook;
	private Date registedDate;
	private Date updatedDate;
	private Date lastLoginDate;

	@Id
	@GeneratedValue
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public Date getRegistedDate() {
		return registedDate;
	}

	public void setRegistedDate(Date registedDate) {
		this.registedDate = registedDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname="
				+ lname + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + ", pass=" + pass + ", qq=" + qq
				+ ", weibo=" + weibo + ", facebook=" + facebook
				+ ", registedDate=" + registedDate + ", updatedDate="
				+ updatedDate + ", lastLoginDate=" + lastLoginDate + "]";
	}

	
}
