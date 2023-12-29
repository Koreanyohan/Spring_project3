package com.example.demo.repository;
//3장 27페이지 JPQL 부분 	   -> MemoRepository_Test1_4으로 테스트
//3장 28페이지 순수 sql사용하여 조회 -> MemoRepository_Test1_4으로 테스트
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Memo;



public interface MemoRepository_3 
extends JpaRepository<Memo, Integer> {
	// <JPQL 사용하기>
		//JPQL 1) 메모의 번호가 매개변수 보다 작은 데이터 검색
//순수sql로 적으면 : select * from tbl_memo where no< ?
		@Query("select m from Memo m where m.no<:mno ") // select m에서 m대신 칼럼 넣기 가능.
		List<Memo> list1(@Param("mno") int mno);
			// @Param이 @Query문의 :mno를 통해 파라미터 인식, 자기 매개변수로 넣어줌.
		
		
		//JPQL 2) 메모의 내용이 있는 데이터 검색
//순수sql로 적으면 : select * from tbl_memo where text is not null
		@Query("select m from Memo m where m.text is not null")
		List<Memo> list2();
		
		
		//JPQL 3) 메모의 번호가 from에서 to사이인 데이터 검색
//순수 sql로 적으면 :select & from tbl_memo where no between ? and ?		
		@Query("select m from Memo m where m.no between :from and :to")
		List<Memo> list3(@Param("from") int from, @Param("to") int to);
		// !!    콜론(:)뒤에 공백 있으면 안된다.
		
		
	// <순수한 쿼리 사용하기>
		//메모의 번호를 기준으로 역정렬
		//순수 sql로 적으면 : select * from tbl_memo order by no desc
		@Query(value = "select * from tbl_memo order by no desc", nativeQuery = true)  // nativeQuery = true 꼭 넣어줘야 순수 sql @Query문에 적용
		List<Memo> list4();
	//cf) 오라클에서 쓰면 순수sql대신 오라클문 써줌
		
}









