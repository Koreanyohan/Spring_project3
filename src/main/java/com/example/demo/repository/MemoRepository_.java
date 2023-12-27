package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Memo;


public interface MemoRepository_ extends JpaRepository<Memo, Integer> { // Memo라는 엔티티클래스를 처리하는 repository MemoRepository
												// JpaRepository 인-페 상속 받으면서 Memo엔티티를 다룰 수 있게 됨.(CURD, 페이징,정렬)
											// -> jpaRepository 상속 받은 인-페 MemoReository는 스프링부트 컨테이너에 인-페구현한 객체 생성함.

}
