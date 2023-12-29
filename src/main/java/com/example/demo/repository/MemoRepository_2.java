package com.example.demo.repository;
//3장 25페이지~ 쿼리 메서드 부분   -> MemoRepository_Test1_3으로 테스트

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

@Transactional // 내가 처리한 작업을 반영하거나 취소하는 기능.
// ㄴ delete같은 기능은 테이블에 영향 미칠수있는 기능이라, 사용위해 이거 추가
public interface MemoRepository_2 
extends JpaRepository<Memo, Integer> {
	
	
	//메모의 번호(no)가 매개변수(특정 범위)인 데이터 검색 -> List에 담김
	List<Memo> findByNoBetween(int from, int to); 
	// ㄴ 조건 검색 쿼리메서드 추가 - between범위의 데이터 검색
	// ㄴ Select * from tbl_memo where no between ? and ? 절의 where절에 해당함.

	//메모의 번호(no)가 매개변수보다 작은 데이터 검색 -> List에 담김
	List<Memo> findByNoLessThan(int mno);
	
	//메모의 내용(text)이 있는 데이터 검색 -> List에 담김
	List<Memo> findByTextIsNotNull();
	
	//메모의 번호를 기준으로 역정렬
	List<Memo> findAllByOrderByNoDesc();
	
	
	//메모의 번호가 매개변수보다 작은 데이터 삭제
//	void delete Memo By NoLessThan (int mno);
	void deleteMemoByNoLessThan (int mno);
	// ㄴ 애너테이션 @Transactional 클래스에 추가
	
	
	
}









