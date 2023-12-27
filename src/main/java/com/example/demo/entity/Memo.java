package com.example.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Entity 클래스화 -> 클래스 내부에 primary key 가지고 있어야
@Table(name = "tbl_memo") // "~" = 실제 db에 있는 테이블 이름 명시
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {
	@Id // primary key라는 표시. 당근 not null
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	// ㄴ GeneratedValue:생성방식 - identity방식(auto_increament) 설정
	int no; // 번호
	
	@Column(length = 200, nullable = true) 
	// ㄴ 칼럼의 길이를 200으로 잡음. nullable = true는 null입력 가능하다는 말이다. false면 반대지.
	String text;  // 내용 
}
