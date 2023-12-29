package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepository_Test {

	@Autowired
	OrderRepository OrderRep ;
	
	@Test
	void 테이블생성용() {
	}
		
	// 1. 데이터추가
	@Test
	void 테이블추가 () { // -> 시스템이 입력하는 것은 생략해도 된다.
	List<Order> list = new ArrayList<>();
	LocalDate localDate1 = LocalDate.of(2023, 7, 1);
	LocalDate localDate2 = LocalDate.of(2023, 7, 2);
	
	Order order1 = new Order(1, "둘리", localDate1, "인천 구월동");
	Order order2 = new Order(2, "또치", localDate2, "인천 연수동");
	Order order3 = new Order(3, "도우너", LocalDate.of(2023, 7, 3), "인천 동래동");
	
//	Order order1 = new Order(0, "둘리", localDate1, "인천 구월동");
//	Order order2 = new Order(0, "또치", localDate2, "인천 연수동");
//	Order order3 = new Order(0, "도우너", LocalDate.of(2023, 7, 3), "인천 동래동");
	
	list.add(order1);
	list.add(order2);
	list.add(order3);
	
	OrderRep.saveAll(list);
	
	}	
	
	
	// 2. 데이터 조회
	
	@Test
	void 데이터조회 () {
	List<Order> list = OrderRep.findAll();
	
	for (Order order : list) {
		System.out.println(order); 
		
	}
	}
	
	
	// 3. 데이터 수정
	
	@Test
	void 데이터하나수정 () {
		
		Optional<Order> opt = OrderRep.findById(2);
		
		if(opt.isPresent()) {
			Order order = opt.get();
			order.setShipAddress("인천 부평구");
			OrderRep.save(order);			
		}
	}
	
	// 4. 데이터 삭제
	
	@Test
	void 데이터_하나만_삭제() {
		OrderRep.deleteById(1);
	}
	
	@Test
	void 데이터_전부_삭제() {
		OrderRep.deleteAll();
	}	
	
	
	
}


























