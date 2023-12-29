package com.example.demo.repository;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
//3장 25페이지 쿼리 메서드 부분   -> MemoRepository_2에 조건 검색 쿼리메서드 추가

/*
 * 페이징 및 정렬기능 사용하기
 * */
@SpringBootTest
public class MemoRepository_Test1_3 {

	@Autowired
	MemoRepository_2 repository;

	// 쿼리메서드 적용 테스트 1.
	@Test// <= List<Memo> findByNoBetween(int from, int to); 
	public void 번호가10과_20사이인_메모검색 () {		
		List<Memo> list = repository.findByNoBetween(0, 20);
				
		for(Memo memo : list) {
			System.out.println(memo);
		}				
		List<Memo> list2 = repository.findByNoBetween(30, 50);
		
		for(Memo memo : list2) {
			System.out.println(memo);
		}
	}
	
	// 쿼리메서드 적용 테스트 2.
	@Test // <= MemoRepository_2의 List<Memo> findByNoLessThan(int mno);
	public void 번호가_10보다작은_메모검색() {
		List<Memo> list = repository.findByNoLessThan(10);
		
		for (Memo memo : list) {
			System.out.println(memo);
		}	
	}
	
	// 쿼리메서드 적용 테스트 3.
	@Test
	public void 텍스트가null아닌_메모검색() {	// <=  List<Memo> findByTextIsNotNull();	
		List<Memo> list = repository.findByTextIsNotNull();
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	// 쿼리메서드 적용 테스트 4.
	@Test
	public void 번호를기준으로역정렬한_메모검색() {// <=  List<Memo> findAllByOrderByNoDesc();
		List<Memo> list = repository.findAllByOrderByNoDesc();
		for(Memo memo : list) {
			System.out.println(memo);
		}		
	}	
	
	// 쿼리메서드 적용 테스트 5.	
	@Test
	public void 번호가_5보다작은_메모삭제() {
		repository.deleteMemoByNoLessThan(10);
	//repository에 @Transactional 없다면 에러남
	//deleteBy는 기본적으로 롤백처리가 되어 결과가 반영되지 않음.		
	}
}
	











