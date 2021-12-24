package com.j6.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "lichsutiem")
public class lichsutiem implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idlichsutiem;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaytiem")
	Date ngaytiem = new Date();
	String loso;
	
	@ManyToOne()
	@JoinColumn(name = "dottiem_iddottiem")
	dottiem dottiem;
	@ManyToOne()
	@JoinColumn(name = "nhanvien_idnhanvien")
	nhanvien nhanvien;
	@ManyToOne()
	@JoinColumn(name = "dangkytiemchung_iddangkytiemchung")
	nguoitiem dangkytiemchung;
	public Long getIdlichsutiem() {
		return idlichsutiem;
	}
	public void setIdlichsutiem(Long idlichsutiem) {
		this.idlichsutiem = idlichsutiem;
	}
	public Date getNgaytiem() {
		return ngaytiem;
	}
	public void setNgaytiem(Date ngaytiem) {
		this.ngaytiem = ngaytiem;
	}
	public String getLoso() {
		return loso;
	}
	public void setLoso(String loso) {
		this.loso = loso;
	}
	public dottiem getDottiem() {
		return dottiem;
	}
	public void setDottiem(dottiem dottiem) {
		this.dottiem = dottiem;
	}
	public nhanvien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}
	public nguoitiem getDangkytiemchung() {
		return dangkytiemchung;
	}
	public void setDangkytiemchung(nguoitiem dangkytiemchung) {
		this.dangkytiemchung = dangkytiemchung;
	}
	
	
}
