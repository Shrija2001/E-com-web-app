package com.MainApp.Pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_info")
public class Product {

	@Id
	String pname;
	@Column
	String uname;
	@Column
	String pdes;
	@Column
	String pprice;
	@Column
	String pq;
	@Column
	String pdis;
	@Column
	String pimgname;
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPdes() {
		return pdes;
	}
	public void setPdes(String pdes) {
		this.pdes = pdes;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getPq() {
		return pq;
	}
	public void setPq(String pq) {
		this.pq = pq;
	}
	public String getPdis() {
		return pdis;
	}
	public void setPdis(String pdis) {
		this.pdis = pdis;
	}
	public String getPimgname() {
		return pimgname;
	}
	public void setPimgname(String pimgname) {
		this.pimgname = pimgname;
	}
	@Override
	public String toString() {
		return "Product [pname=" + pname + ", uname=" + uname + ", pdes=" + pdes + ", pprice=" + pprice + ", pq=" + pq
				+ ", pdis=" + pdis + ", pimgname=" + pimgname + "]";
	}
	
	
	
}
