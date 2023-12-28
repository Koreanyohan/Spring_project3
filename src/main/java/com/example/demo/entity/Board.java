package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

//엔티티에 변화를 감지하는 리스너 지정 (엔티티에 변화시에 내용수행)
@EntityListeners(AuditingEntityListener.class)
//<- Project03Application.java의 @EnableJpaAuditing
//<- Project03Application.java의 @SpringBootApplication
@Entity // jpa 이용위해 반드시 적기 jpa->table에 매핑
@Table(name="tbl_board") // name = "테이블이름 명시"
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
	
	@Id // pk 지정
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto_increament
	int boardNo ;
	
	@Column(length = 30, nullable = false)
	String title;
	
	@Column(length = 200)
	String content;
	
	@CreatedDate // 인스턴스가 생성되는 것을 감지하여 날짜를 저장 - // 한번 등록되고 안바뀜
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 날짜는 꼭 포맷을 지정해야함 - ISO8601 날짜와 관련된 표준에 따라 포맷지정
	LocalDateTime createdDate ; 
	
	
	@LastModifiedDate // 인스턴스가 수정되는 것을 감지하여 날짜를 저장 - //수정할때마다 바뀜
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime modifiedDate;
	
	// 등록일자, 수정일자 셋트다.
	// Date관련 - 1. LocalDateTime 클래스 / 2. Date 클래스
	
//	<게시물>
//	* 사용자가 입력하는지? 시스템이 입력하는지?
//			
//	게시물번호 -> 시스템
//	제목 -> 사용자
//	내용 -> 사용자
//	등록일자 -> 시스템
//	수정일자 -> 시스템
}















