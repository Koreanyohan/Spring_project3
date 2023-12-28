package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
//ㄴ 위의 두 애너테이션 : Jpa 검사 기능을 활성화하여 데이터가 생성 및 수정되는 것을 추적함 
//				-> Board엔티티의 EntityListner가 감지하고 날짜에 입력
public class Project03Application {

	public static void main(String[] args) {
		SpringApplication.run(Project03Application.class, args);
	}

}

