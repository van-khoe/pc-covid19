package com.j6.entity;

import java.io.Serializable;
import java.sql.Time;
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
@Table(name = "phieutiem")
public class phieutiem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idphieutiem;
	String cosoyte;
	String diachi;

	@ManyToOne
	@JoinColumn(name = "dangkytiemchung_iddangkytiemchung")
	nguoitiem dangkytiemchung;
	@ManyToOne
	@JoinColumn(name = "dottiem_iddottiem")
	dottiem dottiem;
}
