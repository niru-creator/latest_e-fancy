package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.enittiy.product;

public interface productRepository extends PagingAndSortingRepository<product,Integer>{
	List<product> findAllByCategory_Id(int id);
	

//	List<product> findAllById(int id);
	
	@Query("select p from product p where p.name like %?1%"
			+ "OR p.category.name like %?1%"
			+ "OR CONCAT(p.price, '') LIKE %?1%"
			+ "OR p.description like %?1%"
			)	
	public List<product> findAllProduct(String key);
	
	
	public List<product> findAll();


	
//current page
//contact per page=5
	

}
