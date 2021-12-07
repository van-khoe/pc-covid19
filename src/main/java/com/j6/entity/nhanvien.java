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
}
