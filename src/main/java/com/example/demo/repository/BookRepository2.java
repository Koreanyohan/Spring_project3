package com.example.demo.repository;
// p.29-30 quuiz 1~6번 풀기
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;
import com.example.demo.entity.Memo;

public interface BookRepository2
extends JpaRepository<Book, Integer>{

	
	// <순수한 쿼리 사용하기>
	
	// 1. 제목이 자바프로그래밍입문인 책을 검색
	@Query(value = "select * from tbl_book where title='자바프로그래밍입문' order by book_No desc", nativeQuery = true)  // nativeQuery = true 꼭 넣어줘야 순수 sql @Query문에 적용
			List<Book> list1();
	
	// 2. 가격이 3만원 이상이고 출판사가 남가락북스인 책을 검색
	@Query(value = "select * from tbl_book where price>30000 and publisher='남가람북스' order by book_No desc", nativeQuery = true)  // nativeQuery = true 꼭 넣어줘야 순수 sql @Query문에 적용
			List<Book> list2();
	
	// 3. 출판사가 한빛출판사 또는 이지스퍼블리싱인 책을 검색
	@Query(value = "select * from tbl_book where publisher = '한빛출판사' or publisher = '이지퍼블리싱' order by book_No desc", nativeQuery = true)  // nativeQuery = true 꼭 넣어줘야 순수 sql @Query문에 적용
			List<Book> list3();

	
	// 답지 풀이 따라가자.. 내 풀이는 검색하고 싶은것을 repository에 넣어버려서 결과적으로 틀린 풀이
	
	
	
	
	
	
	
	
	
//	
//	//<JPQL> 사용하기
//	
//	//4. 제목이 자바프로그래밍입문인 책을 검색
	
	@Query(value = "select * from tbl_book where=:title order by book_No desc", nativeQuery = true)  // nativeQuery = true 꼭 넣어줘야 순수 sql @Query문에 적용
	List<Book> list4(@Param("title") String title);
	
//	//5. 가격이 '3만원'이상이고 출판사가 '남가락북스'인 책을 검색

	@Query(value = "select * from tbl_book where:price and :publisher order by book_No desc", nativeQuery = true)
List<Book> list5(@Param("price") int Price, @Param("publisher") String publisher);

	//6. 출판사가 한빛출판사 또는 이지스퍼블리싱인 책을 검색
	@Query(value = "select * from tbl_book where=:publisher1  or =:publisher2 order by book_No desc", nativeQuery = true)
	List<Book> list6(@Param("publisher") String publsiehr1,  @Param("publisher") String publsiehr2);
	
	
	
	
	
}

























