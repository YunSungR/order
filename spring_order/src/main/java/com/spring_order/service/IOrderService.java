package com.spring_order.service;

import java.util.ArrayList;

import com.spring_order.model.CartVO;
import com.spring_order.model.MemberVO;
import com.spring_order.model.OrderInfoVO;
import com.spring_order.model.Payed_listVO;
import com.spring_order.model.ProductVO;

public interface IOrderService {
	MemberVO memList(String memId);
	void ordInfo(OrderInfoVO vo);
	ArrayList<CartVO> cartList(String memId);
	void insertOrd(Payed_listVO vo);
	int countOrd(String ocode);
}
