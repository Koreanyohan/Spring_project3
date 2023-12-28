package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepository_Test {

	@Autowired
	GiftRepository giftRepo;
	
	@Test
	void 테이블create하려고_그냥_만든거(){
		
	}
	
	// 1. 데이터 추가
	@Test
	void 데이터추가하기() {
	List<Gift> list = new ArrayList<>();
	
	Gift gift1 = new Gift(1, "참치세트", 10000, "식품");
	Gift gift2 = new Gift(2, "햄세트", 20000, "식품");
	Gift gift3 = new Gift(3, "샴푸세트", 30000, "생활용품");
	Gift gift4 = new Gift(4, "세차용품", 40000, "생활용품");
	Gift gift5 = new Gift(5, "주방용품", 50000, "생활용품");
	Gift gift6 = new Gift(6, "노트북", 60000, "가전제품");
	Gift gift7 = new Gift(7, "벽걸이TV", 70000, "가전제품");
	
	
	list.add(gift1);
	list.add(gift2);
	list.add(gift3);
	list.add(gift4);
	list.add(gift5);
	list.add(gift6);
	list.add(gift7);
	
	giftRepo.saveAll(list);	
	
	}
	
	
	// 데이터 조회하기
	
	@Test
	void 데이터조회하기() {
		List<Gift> list = giftRepo.findAll();
		
		for (Gift gift : list) {
			System.out.println(gift);
		}
		
		
	}
	
	// 데이 수정하기
	
	@Test
	void 데이터수정하기 () {
		Optional<Gift> gpt = giftRepo.findById(1);
		Gift giftt = gpt.get();
		
		giftt.setName("장수돌침대");
		
		giftRepo.save(giftt);
		
	
	}
			
	//데이터 삭제하기
	
	@Test
	void 특정데이터삭제하기() {
		giftRepo.deleteById(1);
		
	}
	
	@Test
	void 데이터전부삭제하기() {
		giftRepo.deleteAll();
	}
	
	
}


	 












