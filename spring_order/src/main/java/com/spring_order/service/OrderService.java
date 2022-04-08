package com.spring_order.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_order.dao.IOrderDAO;
import com.spring_order.model.CartVO;
import com.spring_order.model.MemberVO;
import com.spring_order.model.OrderInfoVO;
import com.spring_order.model.Payed_listVO;
import com.spring_order.model.ProductVO;

@Service
public class OrderService implements IOrderService {

	@Autowired
	IOrderDAO dao;
	@Override
	public MemberVO memList(String memId) {
		// TODO Auto-generated method stub
		return dao.memList(memId);
	}
	@Override
	public void ordInfo(OrderInfoVO vo) {
		// TODO Auto-generated method stub
		dao.ordInfo(vo);
	}
	
	@Override
	public ArrayList<CartVO> cartList(String memId) {
		// TODO Auto-generated method stub
		return dao.cartList(memId);
	}
	@Override
	public void insertOrd(Payed_listVO vo) {
		// TODO Auto-generated method stub
		dao.insertOrd(vo);
	}
	@Override
	public int countOrd(String ocode) {
		// TODO Auto-generated method stub
		return dao.countOrd(ocode);
	}

}
