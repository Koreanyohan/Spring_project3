package com.example.demo.entity;
// quiz2  3장 20페이지
import jakarta.annotation.Generated;
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

@Entity
@Table(name="tbl_Gift")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gift {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	int no;
	
	@Column(length=20)
	String name;

	@Column(nullable = true)
	int price;
	
	@Column(length=20)
	String type;	

}






















