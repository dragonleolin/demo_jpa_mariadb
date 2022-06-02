package com.example.demoJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoJPA.ProductInfoDto;
import com.example.demoJPA.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(nativeQuery = true, value = "select * from product")
	List<ProductInfoDto> findAllProduct();

	@Query(nativeQuery = true, value = "select * from product where id = ?1")
	List<ProductInfoDto> findProductById(int id);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "INSERT INTO product (name, location, descript, price, unit)  "
			+ "VALUES (?1, ?2, ?3, ?4, ?5)")
	void createProduct(String name, String location, String descript, int price, String unit);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE product \r\n"
			+ "SET name=?1, location=?2, descript=?3, price=?4, unit=?5 \r\n" + "WHERE id=?6")
	void updateProduct(String name, String location, String descript, int price, String unit, int id);

}
