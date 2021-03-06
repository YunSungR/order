package com.spring_order.dao;

import java.util.ArrayList;

import com.spring_order.model.CartVO;
import com.spring_order.model.MemberVO;
import com.spring_order.model.OrderInfoVO;
import com.spring_order.model.Payed_listVO;

public interface IOrderDAO {
	MemberVO memList(String memId);
	void ordInfo(OrderInfoVO vo);
	ArrayList<CartVO> cartList(String memId);
	void insertOrd(Payed_listVO vo);
	int countOrd(String ocode);
	
}
