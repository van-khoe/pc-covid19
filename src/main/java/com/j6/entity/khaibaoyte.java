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
@Table(name = "khaibaoyte")
public class khaibaoyte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idkhaibaoyte;
	String hoten;
	String cmnd;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaysinh")
	Date ngaysinh = new Date("2020/01/01");
	boolean gioitinh;
	String diachi;
	String bieuhien;
	boolean tiepxuc;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaykhaibao")
	Date ngaykhaibao = new Date();
	
	@ManyToOne
	@JoinColumn(name = "taikhoan_username")
	taikhoan account;

	public Long getIdkhaibaoyte() {
		return idkhaibaoyte;
	}

	public void setIdkhaibaoyte(Long idkhaibaoyte) {
		this.idkhaibaoyte = idkhaibaoyte;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getBieuhien() {
		return bieuhien;
	}

	public void setBieuhien(String bieuhien) {
		this.bieuhien = bieuhien;
	}

	public boolean getTiepxuc() {
		return tiepxuc;
	}

	public void setTiepxuc(boolean tiepxuc) {
		this.tiepxuc = tiepxuc;
	}

	public Date getNgaykhaibao() {
		return ngaykhaibao;
	}

	public void setNgaykhaibao(Date ngaykhaibao) {
		this.ngaykhaibao = ngaykhaibao;
	}

	public taikhoan getAccount() {
		return account;
	}

	public void setAccount(taikhoan account) {
		this.account = account;
	}
	
	
}
