package com.j6.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "capquyen", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "taikhoan_username", "vaitro_idvaitro" }) })
public class capquyen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idcapquyen;
	
	@ManyToOne
	@JoinColumn(name = "taikhoan_username")
	private taikhoan account;
	@ManyToOne
	@JoinColumn(name = "vaitro_idvaitro")
	private vaitro role;
	public int getIdcapquyen() {
		return idcapquyen;
	}
	public void setIdcapquyen(int idcapquyen) {
		this.idcapquyen = idcapquyen;
	}
	public taikhoan getAccount() {
		return account;
	}
	public void setAccount(taikhoan account) {
		this.account = account;
	}
	public vaitro getRole() {
		return role;
	}
	public void setRole(vaitro role) {
		this.role = role;
	}
	
	
}
