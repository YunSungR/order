package com.spring_order.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_order.model.CartVO;
import com.spring_order.model.MemberVO;
import com.spring_order.model.OrderInfoVO;
import com.spring_order.model.Payed_listVO;
import com.spring_order.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService service;
	
	@RequestMapping("/")
	public String order(Model model) {
		MemberVO memInfo=service.memList("hong");
		ArrayList<CartVO> cart=service.cartList("hong");
		System.out.println("adsad"+cart);
		model.addAttribute("memInfo", memInfo);
		model.addAttribute("cart",cart);
		return "orderform";
	}

	@RequestMapping("/orderComplete")
	public String orderComplete() {
		
		return "orderComplete";
	}
	@ResponseBody
	@RequestMapping("/orderCard")
	public int orderCard(OrderInfoVO ordvo
			) {
		int res=0;
		
		System.out.println("123" +ordvo.getOr_hp());
		long timeNum = System.currentTimeMillis();
		//날짜시간 포맷 : MM(월), mm(분), HH(시:24시간제) 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmss");
		String  strTime = dayTime.format(new Date(timeNum));
		
		//랜덤 숫자 4개 생성
		String rNum = "";
		for(int i=1; i<=4; i++) {
			rNum += (int)(Math.random() * 10);
		}
		
		String ordNo = strTime + "_" + rNum;
		System.out.println(ordNo);
		//주문번호 설정
		ordvo.setOcode(ordNo);
		ordvo.setUser_id("hong");
		service.ordInfo(ordvo);
		if(service.countOrd(ordNo)>0) {
			res=1;
		}
		return res;
	}
}
