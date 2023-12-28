package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepository_Test {

	@Autowired
	BoardRepository repository ;
	
	
	@Test
	void repository객체를_가져왔는지_확인 () {
		System.out.println();
		System.out.println("repository = " + repository);
		System.out.println();		
	}
	
	
	// 1. 데이터 등록하기
	@Test
	public void 데이터등록() {
//		// 데이터 등록
//		Board board1 = new Board(0, "1번글", "내용입니다", null, null); // 날짜 생략
//		repository.save(board1); // 등록일과 수정일이 현재시간으로 자동 등록됨
//	
//		// 데이터 등록
//		Board board2 = Board.builder()
//				.title("2번글").content("내용입니다")
//				.build(); //날짜생략
//		repository.save(board2);
		
		List<Board> list = new ArrayList<>();
		Board board1 = new Board(1, "1번글", "내용입니다", null, null); // 날짜 생략
		Board board2 = Board.builder()
				.title("2번글").content("내용입니다")
				.build(); //날짜생략
		list.add(board1);
		list.add(board2);
		
		repository.saveAll(list);
	}
	
	
	// 2. 데이터 조회
	@Test
	public void 데이터하나조회 () {
		Optional<Board> result = repository.findById(5); // pk조회 - board_no가 1인 데이터 조회
		if (result.isPresent()) { // 결과값이 있는지 확인
			Board board = result.get(); // 값 꺼내기 (get은 Optional의 메서드)
			System.out.println(board);
		}				
	}
	
	@Test
	public void 데이터전체조회 () {
		List<Board> list = repository.findAll();
		
		for(Board board : list) {
			System.out.println(board);
		}
	}
	
	
	// 3. 데이터 수정
	@Test
	public void 데이터수정() {
		// 1번 게시물 조회 (수정하고 싶은 데이터 고르기)
		Optional<Board> result = repository.findById(1); 
		Board board = result.get(); // 엔티티꺼내기.    
		
		//일부 값 변경 (pk==1인 컬럼값) - 없으면 pk=1인 컬럼만듬. 즉, update가 아닌, insert
		board.setContent("내용이 수정되었습니다~"); 
		
		// 1번이 존재하는지 확인하고 update 실행
		repository.save(board);	
		
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

