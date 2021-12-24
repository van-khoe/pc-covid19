package com.j6.entity;

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

@Data
@Entity
@Table(name = "blog")
public class blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idblog;
	String tieude;
	String noidung;
	String hinhanh;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaytao")
	Date ngaytao = new Date();
	
	@ManyToOne
	@JoinColumn(name = "nguoitao")
	taikhoan account;

	public Integer getIdblog() {
		return idblog;
	}

	public void setIdblog(Integer idblog) {
		this.idblog = idblog;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public taikhoan getAccount() {
		return account;
	}

	public void setAccount(taikhoan account) {
		this.account = account;
	}
	
	
}
