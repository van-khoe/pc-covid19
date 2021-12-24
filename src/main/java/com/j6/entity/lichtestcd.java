package com.j6.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "lichtestcd")
public class lichtestcd implements Serializable {
	@Id
	int idlichtestcd;
	Date ngaytest;
	int soluongnguoitest;
	int mauamtinh;
	int mauduongtinh;
	String tinhthanh;
	public int getIdlichtestcd() {
		return idlichtestcd;
	}
	public void setIdlichtestcd(int idlichtestcd) {
		this.idlichtestcd = idlichtestcd;
	}
	public Date getNgaytest() {
		return ngaytest;
	}
	public void setNgaytest(Date ngaytest) {
		this.ngaytest = ngaytest;
	}
	public int getSoluongnguoitest() {
		return soluongnguoitest;
	}
	public void setSoluongnguoitest(int soluongnguoitest) {
		this.soluongnguoitest = soluongnguoitest;
	}
	public int getMauamtinh() {
		return mauamtinh;
	}
	public void setMauamtinh(int mauamtinh) {
		this.mauamtinh = mauamtinh;
	}
	public int getMauduongtinh() {
		return mauduongtinh;
	}
	public void setMauduongtinh(int mauduongtinh) {
		this.mauduongtinh = mauduongtinh;
	}
	public String getTinhthanh() {
		return tinhthanh;
	}
	public void setTinhthanh(String tinhthanh) {
		this.tinhthanh = tinhthanh;
	}
	
	
}
