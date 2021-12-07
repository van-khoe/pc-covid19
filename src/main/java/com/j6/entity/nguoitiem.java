package com.j6.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")

@Data
@Entity
@Table(name = "nguoitiem")
public class nguoitiem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idnguoitiem;
	@NotBlank(message = "Không để trống họ tên")
	String hoten;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaysinh")
	Date ngaysinh = new Date();
	@NotNull(message = "Chọn giới tính")
	Boolean gioitinh;
	@NotBlank(message = "Không để trống CMND")
	String cmnd;
	@NotBlank(message = "Không để trống tiền sử bệnh")
	String tiensubenh;
	@NotBlank(message = "Không để trống email")
	@Email(message = "Email không đúng định dạng")
	String email;

	@ManyToOne
	@JoinColumn(name = "taikhoan_username")
	taikhoan account;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dangkytiemchung")
	List<lichsutiem> lichsutiem;
	@JsonIgnore
	@OneToMany(mappedBy = "dangkytiemchung")
	List<phieutiem> phieudangkylichhen;
	
	public Integer getIdnguoitiem() {
		return idnguoitiem;
	}
	public void setIdnguoitiem(Integer idnguoitiem) {
		this.idnguoitiem = idnguoitiem;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public Boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getTiensubenh() {
		return tiensubenh;
	}
	public void setTiensubenh(String tiensubenh) {
		this.tiensubenh = tiensubenh;
	}
	public taikhoan getAccount() {
		return account;
	}
	public void setAccount(taikhoan account) {
		this.account = account;
	}
	public List<lichsutiem> getLichsutiem() {
		return lichsutiem;
	}
	public void setLichsutiem(List<lichsutiem> lichsutiem) {
		this.lichsutiem = lichsutiem;
	}
	public List<phieutiem> getPhieudangkylichhen() {
		return phieudangkylichhen;
	}
	public void setPhieudangkylichhen(List<phieutiem> phieudangkylichhen) {
		this.phieudangkylichhen = phieudangkylichhen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
