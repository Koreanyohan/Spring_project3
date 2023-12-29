package com.example.demo.repository;


import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.*;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepository_Test1_2 {

	@Autowired
	MemoRepository_ repository;
		
	@Test
	void 메모데이터100개등록() {
	// 1~100까지 숫자를 가지는 스트림을 생성하고, forEach 최종연산자로 반복작업을 수행
	IntStream
			.rangeClosed(1, 100) // 1~100 텍스트 내용 有			
			.forEach(i -> {
				Memo memo = Memo.builder()
						.text("Sample.."+ i)
						.build();
				repository.save(memo);						
			});

	IntStream
	.rangeClosed(101, 200) // 101~200 텍스트 내용 無
	.forEach(i -> {
		Memo memo = Memo.builder()				
				.build();
		repository.save(memo);						
	});
	
	
	}			
	
	@Test
	void 페이징처리() {
	
		//페이지번호와 데이터개수를 담아서 페이지 정보 생성 - !! 페이지번호 데이터갯수 (페이지 정렬) 정보 담은 Pageable 인스턴스 생성
		Pageable pageable = PageRequest.of(1, 10); //domain추가!!
							// ㄴ Pageable의 구현 인스턴스 생성 
		//페이지 정보를 전달하여 데이터 조회하기 
		Page<Memo> page = repository.findAll(pageable); //domain추가 !!
								//	여기서 findAll메서드는 조회기능이 아니라 매개변수 넣음으로써 페이지조건(pageable)에 맞는 데이터만 가지고 오는 의미가 됨.
			//전에 입력한 List<클래스> list = repository.findAll(); 이용해서 repository저장된 객체들 리스트에 넣는거랑 다르지!!!
		
		// 페이지안에 담긴 데이터 꺼내기
		List<Memo> list = page.getContent();
	
		System.out.println(list);
	
	
		//페이지 부가 정보
	System.out.println("총 페이지 : " + page.getTotalPages());
	System.out.println("현재 페이지 번호 : " + page.getNumber());
	System.out.println("페이지당 페이지 갯수 : " + page.getSize());
	System.out.println("다음 페이지 존재 여부 : " + page.hasNext());
	System.out.println("시작 페이지 여부 : " + page.isFirst());
	
	
	
	}
	
	
	@Test
	void 정렬조건추가하기() {
		// no 필드를 기준으로 역정렬하는 조건을 생성
		Sort sort = Sort.by("no").descending(); //Sort domain으로 import!.
							//.ascending은 순정렬 / 게시판은 무조건 역정렬 descending
		
		// 페이지 번호, 데이터개수, 정렬조건을 담아서 페이지 정보 생성
		Pageable pageable = PageRequest.of(1, 10, sort);
		
		// 페이지 정보를 전달하여 데이터 조회
		Page<Memo> page = repository.findAll(pageable);
		
		List<Memo> list = page.getContent();
		
		// 메모번호를 기준으로 역정렬된 데이터가 조회됨
		for (Memo memo : list) {
			System.out.println(memo);
		}
		
	}
}















