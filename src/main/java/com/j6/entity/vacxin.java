package com.j6.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "vacxin")
public class vacxin implements Serializable {
	@Id
	String idvacxin;
	String tenvacxin;
	String tenhang;
	String tenquocgia;
	Integer thoigianmui2;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vacxin")
	List<dottiem> dottiem;

	public String getIdvacxin() {
		return idvacxin;
	}

	public void setIdvacxin(String idvacxin) {
		this.idvacxin = idvacxin;
	}

	public String getTenvacxin() {
		return tenvacxin;
	}

	public void setTenvacxin(String tenvacxin) {
		this.tenvacxin = tenvacxin;
	}

	public String getTenhang() {
		return tenhang;
	}

	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}

	public String getTenquocgia() {
		return tenquocgia;
	}

	public void setTenquocgia(String tenquocgia) {
		this.tenquocgia = tenquocgia;
	}

	public Integer getThoigianmui2() {
		return thoigianmui2;
	}

	public void setThoigianmui2(Integer thoigianmui2) {
		this.thoigianmui2 = thoigianmui2;
	}

	public List<dottiem> getDottiem() {
		return dottiem;
	}

	public void setDottiem(List<dottiem> dottiem) {
		this.dottiem = dottiem;
	}
	
	
}
