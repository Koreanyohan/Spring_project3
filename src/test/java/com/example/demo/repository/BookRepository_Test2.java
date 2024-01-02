package com.example.demo.repository;
// BookRepository2와 연결. 3장 p.29문제
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepository_Test2 {

	
	@Autowired
	BookRepository2 repository;
	
	
	//
	

	//1)
		@Test
		public void 페이지29_1번() {
			List<Book> list = repository.list1();
			
			for(Book book : list) {
				System.out.println(book);
			}
		}
		
	
		
	//2)
		@Test
		public void 페이지29_2번 () {
			List<Book> list = repository.list2();
			
			for(Book book : list) {
				System.out.println(book);
			}
		}	
		
	//3) 
		@Test
		public void 페이지29_3번 () {
			
			List<Book> list = repository.list3();
			
			for(Book book : list) {
				System.out.println(book);
			}		
		}

		// 답지 풀이 따라가자.. 내 풀이는 검색하고 싶은것을 repository에 넣어버려서 결과적으로 틀린 풀이

		
	// <JPQL> 사용하기
		
	//4)
		@Test
		public void 페이지29_4번 () {
			
			List<Book> list = repository.list4("자바프로그래밍입문");
		
			
			for(Book book : list) {
				System.out.println(book);
			}		
		}
		
	//5)
		@Test
		public void 페이지29_5번 () {
					
			List<Book> list = repository.list5(30000,"남가람북스");
				
					
			for(Book book : list) {
				System.out.println(book);
			}		
		}
	
		//6)
		@Test
		public void 페이지29_6번 () {
							
			List<Book> list = repository.list6("한빛출판사", "이지스퍼블리싱");
						
							
			for(Book book : list) {
				System.out.println(book);
			}		
		}
		
}
		






















