package com.example.demo.repository;
import java.util.List;

// 3장 31페이지 Q6
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;
import com.example.demo.entity.Gift;

public interface GiftRepository2 extends JpaRepository<Gift, Integer>{

	// 1.
	@Query(value = "select * from tbl_gift where price>=:price order by no asc", nativeQuery = true)
	List<Gift> list1(@Param("price") int price);
	
	// 2.
		@Query(value = "select * from tbl_gift where name like:'%word' order by no asc", nativeQuery = true)
		List<Gift> list2(@Param("word") String word);
	
		
	// 3. 
}
