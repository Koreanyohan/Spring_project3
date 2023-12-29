package com.example.demo.repository;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
//3장 27페이지 JPQL 부분 -> MemoRepository_3에 조건 검색 쿼리메서드 추가
//3장 28페이지 순수 sql사용하여 조회 -> MemoRepository_3에 조건 검색 쿼리메서드 추가
/*
 * 페이징 및 정렬기능 사용하기
 * */
@SpringBootTest
public class MemoRepository_Test1_4 {

	@Autowired
	MemoRepository_3 repository;

//1)
	@Test
	public void 번호가_15보다_작은_메모검색() {
		List<Memo> list = repository.list1(15);
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
//2)
	@Test
	public void 텍스트가null이_아닌_메모검색() {
		List<Memo> list = repository.list2();
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}	
	
//3) 
	@Test
	public void 번호가_10과_20사이인_메모검색 () {
		
		List<Memo> list = repository.list3(10, 20);
		
		for(Memo memo : list) {
			System.out.println(memo);
		}		
	}

//4) 
	@Test
	public void 메모의_번호를_기준으로_역정렬 () {
		
		List<Memo> list = repository.list4();
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
}
	











