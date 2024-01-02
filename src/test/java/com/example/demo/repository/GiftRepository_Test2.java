package com.example.demo.repository;
import java.util.List;
// 3장 31-32번 문제6.  gg침
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepository_Test2 {

	@Autowired
	GiftRepository2 giftRepo;
	
	@Test
	void Q6문제1번() {
	List<Gift> list = giftRepo.list1(50000);
	
	for(Gift gift : list) {
		System.out.println(gift);
	}
	}
	
	
	@Test
	void Q6문제2번() {
	List<Gift> list = giftRepo.list2("세트");
	
	for(Gift gift : list) {
		System.out.println(gift);
	}
	}
}


	 












