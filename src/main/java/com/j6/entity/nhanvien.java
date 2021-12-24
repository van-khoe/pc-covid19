package com.j6.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "nhanvien")
public class nhanvien {
	@Id
	String idnhanvien;
	String hoten;
	String sdt;
	String email;
	String hinhanh;
	boolean trangthai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nhanvien")
	List<lichsutiem> lichsutiem;

	public String getIdnhanvien() {
		return idnhanvien;
	}

	public void setIdnhanvien(String idnhanvien) {
		this.idnhanvien = idnhanvien;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	public List<lichsutiem> getLichsutiem() {
		return lichsutiem;
	}

	public void setLichsutiem(List<lichsutiem> lichsutiem) {
		this.lichsutiem = lichsutiem;
	}
	
	
}
