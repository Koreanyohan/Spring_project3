package com.example.demo.entity;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "tbl_Order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderNo; // 시스템이 입력
	
	@Column(length=30)
	String customerName;  // 사용자가 입력
	
	@DateTimeFormat
	LocalDate orderDate;  // 사용자가 입력
	
	@Column(length=100)
	String shipAddress;  // 사용자가 입력
	
	

	
	
}
