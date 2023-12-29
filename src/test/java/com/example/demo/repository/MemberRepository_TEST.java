package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepository_TEST {

	@Autowired
	MemberRepository memberRep;
	
	@Test
	void 테이블생성용 () {
		
	}
	
	// 데이터 추가하기
	
	@Test
	void 데이터_추가하기 () {
		
		List<Member> list = new ArrayList<>();
		
		Member member1 = new Member ("admin", "관리자", "1234", null); 
		Member member2 = new Member ("user", "사용자", "1234", null);
		
		list.add(member1);
		list.add(member2);
		
		memberRep.saveAll(list);
		
	}
	
	//데이터 조회하기
	@Test
	void 데이터_조회하기 () {
		Optional<Member> opt = memberRep.findById("admin");
		if(opt.isPresent()) {
		Member mem = opt.get();
		System.out.println(mem);
		}
	}
	
	//데이터 수정하기
	@Test
	void 데이터하나만수정하기 () {
		Optional<Member> member = memberRep.findById("admin");
		if(member.isPresent()) {
			Member mem1 = member.get();
			mem1.setGrade("노예");			
			memberRep.save(mem1);
		}
		
	}
	
	
	//데이터 삭제하기
	@Test
	void 데이터하나만_삭제하기() {
		memberRep.deleteById("admin");
		
	}
	
	@Test
	void 데이터_전부_삭제하기 () {
		memberRep.deleteAll();
	}
	
	
}














