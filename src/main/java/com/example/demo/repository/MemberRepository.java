package com.example.demo.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.entity.Member;



@EnableJpaAuditing
@SpringBootApplication
public interface MemberRepository extends JpaRepository<Member, String>{

}
