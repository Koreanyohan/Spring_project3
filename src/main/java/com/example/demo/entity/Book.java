package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// QUIZ 1. ppt3장-19페이지

@Entity
@Table(name="tbl_Book")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
	// String은 nullable=true이 기본   int는 nullable=false가 기본
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int bookNo;  // camel case 네이밍규칙이 sql가면 스네이크 기법되서 sql에는 book_No로 저장된다. 
	
	@Column(nullable=true)
	int Price;
	
	
	@Column(length=100) 
	String publisher;
	
	@Column(length=30, nullable=true)
	String title;
	// 여기까지 만들고 실행해주면 테이블 생성
}
