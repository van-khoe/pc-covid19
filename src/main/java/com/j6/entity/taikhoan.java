package com.j6.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "taikhoan")
public class taikhoan implements Serializable {

	@Id
	@NotBlank(message = "Không để trống tài khoản")
	String username;
	@NotBlank(message = "Không để trống họ và tên")
	String hoten;
	@NotBlank(message = "Không để trống mật khẩu")
	String matkhau;
	@NotBlank(message = "Không để trống địa chỉ")
	String diachi;
	@NotNull(message = "Chọn giới tính")
	Boolean gioitinh;
	@NotBlank(message = "Không để trống số điện thoại")
	@Pattern(regexp="^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$",message="Số điện thoại không đúng định dạng")  
	String sdt;
	@NotBlank(message = "Không để trống địa chỉ email")
	@Email(message="Địa chỉ email không đúng định dạng")
	String email;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaysinh")
	Date ngaysinh = new Date();
	@NotNull(message = "Tùy chọn trạng thái tài khoản")
	Boolean trangthai;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<khaibaoyte> khaibaoyte;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<nguoitiem> dangkytiemchung;
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<capquyen> capquyen;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public Boolean getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
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
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public Boolean getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}
	public List<khaibaoyte> getKhaibaoyte() {
		return khaibaoyte;
	}
	public void setKhaibaoyte(List<khaibaoyte> khaibaoyte) {
		this.khaibaoyte = khaibaoyte;
	}
	public List<nguoitiem> getDangkytiemchung() {
		return dangkytiemchung;
	}
	public void setDangkytiemchung(List<nguoitiem> dangkytiemchung) {
		this.dangkytiemchung = dangkytiemchung;
	}
	public List<capquyen> getCapquyen() {
		return capquyen;
	}
	public void setCapquyen(List<capquyen> capquyen) {
		this.capquyen = capquyen;
	}
	
	
}
