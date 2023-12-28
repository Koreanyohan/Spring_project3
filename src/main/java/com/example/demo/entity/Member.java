package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Quiz4. 3장 22페이지


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Member {
	@Id		
	String user_id;	
	
	String grade ;
	
	String password;
	
	Date register_Date;
	
}
