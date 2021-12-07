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
}
