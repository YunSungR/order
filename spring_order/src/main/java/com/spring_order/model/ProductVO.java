package com.spring_order.model;

public class ProductVO {
	private String product_cd;
	private String product_nm;
	private int product_stock;
	private int sale_price;
	private int supply_price;
	private int fee_rate;
	private int reserve_rate;
	private int trans_price;
	public String getProduct_cd() {
		return product_cd;
	}
	public void setProduct_cd(String product_cd) {
		this.product_cd = product_cd;
	}
	public String getProduct_nm() {
		return product_nm;
	}
	public void setProduct_nm(String product_nm) {
		this.product_nm = product_nm;
	}
	public int getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	public int getSale_price() {
		return sale_price;
	}
	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}
	public int getSupply_price() {
		return supply_price;
	}
	public void setSupply_price(int supply_price) {
		this.supply_price = supply_price;
	}
	public int getFee_rate() {
		return fee_rate;
	}
	public void setFee_rate(int fee_rate) {
		this.fee_rate = fee_rate;
	}
	public int getReserve_rate() {
		return reserve_rate;
	}
	public void setReserve_rate(int reserve_rate) {
		this.reserve_rate = reserve_rate;
	}
	public int getTrans_price() {
		return trans_price;
	}
	public void setTrans_price(int trans_price) {
		this.trans_price = trans_price;
	}
}
