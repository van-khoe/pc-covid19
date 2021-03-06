package com.j6.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "dottiem")
public class dottiem implements Serializable {
	@Id
	String iddottiem;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaytiem")
	Date ngaytiem = new Date();
	String diadiemtiem;
	
	@ManyToOne()
	@JoinColumn(name = "vacxin_idvacxin")
	vacxin vacxin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dottiem")
	List<lichsutiem> lichsutiem;
	@JsonIgnore
	@OneToMany(mappedBy = "dottiem")
	List<phieutiem> phieutiem;
	public String getIddottiem() {
		return iddottiem;
	}
	public void setIddottiem(String iddottiem) {
		this.iddottiem = iddottiem;
	}
	public Date getNgaytiem() {
		return ngaytiem;
	}
	public void setNgaytiem(Date ngaytiem) {
		this.ngaytiem = ngaytiem;
	}
	public String getDiadiemtiem() {
		return diadiemtiem;
	}
	public void setDiadiemtiem(String diadiemtiem) {
		this.diadiemtiem = diadiemtiem;
	}
	public vacxin getVacxin() {
		return vacxin;
	}
	public void setVacxin(vacxin vacxin) {
		this.vacxin = vacxin;
	}
	public List<lichsutiem> getLichsutiem() {
		return lichsutiem;
	}
	public void setLichsutiem(List<lichsutiem> lichsutiem) {
		this.lichsutiem = lichsutiem;
	}
	public List<phieutiem> getPhieutiem() {
		return phieutiem;
	}
	public void setPhieutiem(List<phieutiem> phieutiem) {
		this.phieutiem = phieutiem;
	}
	
	
}
