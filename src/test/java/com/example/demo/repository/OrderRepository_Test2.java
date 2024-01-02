package com.example.demo.repository;
//3장 p.33 Q.7
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepository_Test2 {

	@Autowired
	OrderRepository2 OrderRep;
	
	@Test
	void 문제1() {
		List<Order> list = OrderRep.get1("인천");
		
		for(Order order : list) {
			System.out.println(order);
		}		
	}
	
	
	@Test
	void 문제2() {
//		List<Order> list = OrderRep.get2(LocalDate.of(2023, 07, 03));
		
		LocalDate localdate = LocalDate.of(2023,07,03);
		List<Order> list = OrderRep.get2(localdate);
		
		
//		for(Order order : list) {
//			System.out.println(order);		
//		}			
		
		for (int i = 0; i< list.size(); i++ ) {
			Order order = list.get(i);
			System.out.println(order);
		}
	}
//	
//	
//	@Test
//	void 문제3() {
//		List<Order> list = OrderRep.get3("인천");
//		
//		for(Order order : list) {
//			System.out.println(order);
//		}		
//	}
//
//	
//	@Test
//	void 문제4() {
//		List<Order> list = OrderRep.get4("07-03");
//		
//		for(Order order : list) {
//			System.out.println(order);
//		}		
//	}
}


























