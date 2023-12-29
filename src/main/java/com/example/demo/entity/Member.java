package com.example.demo.entity;


import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Quiz4. 3장 22페이지

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tbl_Member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Member {
	@Id		
	String userId;	
	
	String grade ;
	
	String password;
	@CreatedDate // 인스턴스가 생성되는 것을 감지하여 날짜를 저장 - // 한번 등록되고 안바뀜
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 날짜는 꼭 포맷을 지정해야함 - ISO8601 날짜와 관련된 표준에 따라 포맷지정
	LocalDate registerDate ; 
	
	
	
}
