package com.javamaster.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javamaster.springsecurityjwt.entity.CategoryEntity;
import com.javamaster.springsecurityjwt.service.ICategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryUserController {
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<Iterable<CategoryEntity>> getAllCategory() {
		return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
	}
}
