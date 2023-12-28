package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepository_Test {

	
	@Autowired
	BookRepository repository;
	
	
	//
	
	@Test
	void repository객체를_가져왔는지_확인 () {
		System.out.println();
		System.out.println("repository = " + repository);
		System.out.println();		
	}
	
	//데이터등록
	
	@Test
	public void 데이터등록() {
//		Book book1 = Book.builder()
//				.Price(20000).publisher("한빛출판사").title("자바프로그래밍입문")
//				.build();
//		repository.save(book1);
//		Book book2 = Book.builder()
//				.Price(25000).publisher("남가람북스").title("스프링부트입문")
//				.build();
//		repository.save(book2);
//		Book book3 = Book.builder()
//				.Price(40000).publisher("남가람북스").title("실무로 끝내는 PHP")
//				.build();
//		repository.save(book3);
//		Book book4 = Book.builder()
//				.Price(35000).publisher("이지스퍼블리싱").title("알고리즘 코딩 테스트")
//				.build();
//		repository.save(book4);
		List<Book> listt = new ArrayList<>();
		
		
		Book book1 = Book.builder()
				.Price(20000).publisher("한빛출판사").title("자바프로그래밍입문")
				.build();		
		Book book2 = Book.builder()
				.Price(25000).publisher("남가람북스").title("스프링부트입문")
				.build();
		Book book3 = Book.builder()
				.Price(40000).publisher("남가람북스").title("실무로 끝내는 PHP")
				.build();
		Book book4 = Book.builder()
				.Price(35000).publisher("이지스퍼블리싱").title("알고리즘 코딩 테스트")
				.build();
		
		listt.add(book1);
		listt.add(book2);
		listt.add(book3);
		listt.add(book4);
		
		
		repository.saveAll(listt);
	}
	
	
	
	// 2.데이터 조회하기
	
	@Test
	public void 데이터전체조회() {
		List<Book> list = repository.findAll();
		
		for (Book book : list) {
			System.out.println(book);
		}	
		
	}
	
	
	// 3. 데이터 수정
	@Test
	public void 데이터수정() {
		Optional<Book> result = repository.findById(1);
		
		if(result.isPresent()) { // 이거 사실 다 넣어줘야됨.
		Book bookFirst = result.get(); // repository에 저장된 Book객체(행) 꺼내오는거지
		
		bookFirst.setTitle("나루토");  // 꺼낸 Book객체(행)의 Title멤버변수 수정
		repository.save(bookFirst);
		}
		
		
	}
	
	// 4. 데이터 삭제
		
		@Test
		public void 특정데이터삭제 () {
			repository.deleteById(1);
		}
	
		@Test
		public void 데이터전체삭제 () {
			repository.deleteAll();
		}	
	
}






















