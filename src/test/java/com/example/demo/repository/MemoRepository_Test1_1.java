package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;
/*
 * MemoRepository_를 사용하여
 * 메모테이블의 데이터를 등록, 조회, 수정, 삭제한다.
 * */
@SpringBootTest
public class MemoRepository_Test1_1 {

	@Autowired
	MemoRepository_ memoRepository;
		
	@Test
	void 리파지토리객체를_가져왔는지_확인() {
		System.out.println("memoRepository = " + memoRepository);
	}
	
// 1. 데이터 저장	
	@Test
	public void 데이터등록() { // 데이터 하나 등록하기
		//Memo memo = new Memo(0,"새글입니다");
		Memo memo = Memo.builder().text("새글입니다.").build();
		
		memoRepository.save(memo);		
	}
	
	@Test	
	public void 데이터일괄등록() { // 데이터 여러개 한번에 등록하기 - 객체리스트를 저장
		List<Memo> list = new ArrayList<>();
		
		Memo memo1 = new Memo (0, "새글입니다.");  // 0의 의미 - 진짜 0입력하겠다는게 아니라,  빈값에 순차적으로 입력한다는 말임)
		Memo memo2 = new Memo (0, null);
		
		list.add(memo1);
		list.add(memo2);
		
		memoRepository.saveAll(list); // 두 건에 데이터 한번에 등록
		
	}
	
	
//2. 데이터 조회	
	@Test
	public void 데이터하나조회 () {
		Optional<Memo> result = memoRepository.findById(１);  // Id 의미 = PK. 즉, no가 1인거 찾겠다.
		
		if (result.isPresent()) {//결과값이 있는지 확인 
			Memo memo = result.get(); // 값 꺼내기
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터전체조회 () {
		List<Memo> list = memoRepository.findAll();  // findAll로 나온 값 전부 왼쪽 list에 저장.
		
		for (Memo memo : list) {//결과값이 있는지 확인			
			System.out.println(memo);
		}
	}
	
	
// 3. 데이터 수정
	
	@Test
	public void 데이터수정() {
		Memo memo = new Memo (1, "글이 수정되었습니다.");
		
		// 1번이 존재하는지 확인하고 update 실행
		memoRepository.save(memo); // 상황에 따라 save : insert/update (no가 1인값이 있으면 update / 없으면 마지막 pk 다음값에 insert)
	}
	
	
// 4. 데이터 삭제
	@Test
	public void 데이터_하나_삭제() {
		memoRepository.deleteById(1);  // Id 의미 = PK. 즉, no가 1인거 찾겠다.
		// ㄴ 1번이 존재하는지 확인하고 delete 실행
	}	
	
	@Test
	public void 데이터_전체_삭제() {		
		memoRepository.deleteAll();  		
	}		
}
