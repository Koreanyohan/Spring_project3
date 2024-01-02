package com.example.demo.repository;
import java.time.LocalDate;
import java.util.List;

// 3장 p.33 Q.7 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepository2 extends JpaRepository<Order, Integer>{
	
	
	// 1번
	@Query(value="select * from tbl_order where ship_address like:address%", nativeQuery = true)
	List<Order> get1(@Param("address") String address);
		// 왜 안되...
	
//	
//	
//	
//	// 2번
	@Query(value="select * from tbl_order where order_date=:date", nativeQuery = true)
	List<Order> get2(@Param("date") LocalDate date);
	
//// 주문일이 ‘7월3일’인 주문을 검색
//
//	// 3번
//	@Query("select t from Order t where t.ship_address like concat(:address,'%'")
//	List<Order> get3(@Param("address") String address);
//		
//	// 4번
//	@Query("select t from Order t where t.order_date like:'%date%'")
//	List<Order> get4(@Param("date") String date);

}
