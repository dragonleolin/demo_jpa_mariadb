package com.example.demoJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoJPA.ProductInfoDto;
import com.example.demoJPA.entity.Product;
import com.example.demoJPA.repository.ProductRepository;

@RestController
public class Controller {
	@Autowired
	ProductRepository productRepository;

	// 取得所有產品
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(value = "/products", produces = "application/json")
	public List<ProductInfoDto> getAllProduct() {
		List<ProductInfoDto> allProduct = productRepository.findAllProduct();
		return allProduct;
	}

	// 取得單一
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(value = "/product/{id}")
	public List<ProductInfoDto> getOneProduct(@PathVariable int id) {
		List<ProductInfoDto> oneProduct = productRepository.findProductById(id);
		return oneProduct;
	}

	@PostMapping("/product")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public String createProduct(@RequestBody Product product) {
		String name = product.getName();
		String location = product.getLocation();
		String descript = product.getDescript();
		int price = product.getPrice();
		String unit = product.getUnit();
		productRepository.createProduct(name, location, descript, price, unit);
		return "新增成功";
	}

	@PutMapping("/product/{id}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public String updateOrderItem(@PathVariable int id, @RequestBody Product product) {
		String name = product.getName();
		String location = product.getLocation();
		String descript = product.getDescript();
		int price = product.getPrice();
		String unit = product.getUnit();
		productRepository.updateProduct(name, location, descript, price, unit, id);
		return "修改成功";
	}

}
