package com.spring_order.model;

public class OrderProductVO {

	private String product_ocode;
	private String ocode;
	private String product_gb;
	private String cart_seq;
	private char pay_yn;
	private String product_order_state_cd;
	private int total_price;
	private int total_orgin_price;
	private int qty;
	private int price;
	private int origin_price;
	private int sale_price;
	private int supply_price;
	private int fee_price;
	private int reserve;
	private int total_reserve;
	public String getProduct_ocode() {
		return product_ocode;
	}
	public void setProduct_ocode(String product_ocode) {
		this.product_ocode = product_ocode;
	}
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	public String getProduct_gb() {
		return product_gb;
	}
	public void setProduct_gb(String product_gb) {
		this.product_gb = product_gb;
	}
	public String getCart_seq() {
		return cart_seq;
	}
	public void setCart_seq(String cart_seq) {
		this.cart_seq = cart_seq;
	}
	public char getPay_yn() {
		return pay_yn;
	}
	public void setPay_yn(char pay_yn) {
		this.pay_yn = pay_yn;
	}
	public String getProduct_order_state_cd() {
		return product_order_state_cd;
	}
	public void setProduct_order_state_cd(String product_order_state_cd) {
		this.product_order_state_cd = product_order_state_cd;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getTotal_orgin_price() {
		return total_orgin_price;
	}
	public void setTotal_orgin_price(int total_orgin_price) {
		this.total_orgin_price = total_orgin_price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(int origin_price) {
		this.origin_price = origin_price;
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
	public int getFee_price() {
		return fee_price;
	}
	public void setFee_price(int fee_price) {
		this.fee_price = fee_price;
	}
	public int getReserve() {
		return reserve;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	public int getTotal_reserve() {
		return total_reserve;
	}
	public void setTotal_reserve(int total_reserve) {
		this.total_reserve = total_reserve;
	}
}
