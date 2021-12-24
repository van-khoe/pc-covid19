package com.j6.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "vaitro")
public class vaitro implements Serializable {

	@Id
	String idvaitro;
	String ten;

	@JsonIgnore
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	List<capquyen> capquyen;

	public String getIdvaitro() {
		return idvaitro;
	}

	public void setIdvaitro(String idvaitro) {
		this.idvaitro = idvaitro;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public List<capquyen> getCapquyen() {
		return capquyen;
	}

	public void setCapquyen(List<capquyen> capquyen) {
		this.capquyen = capquyen;
	}
	
	
}
