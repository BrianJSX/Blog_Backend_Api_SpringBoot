package com.javamaster.springsecurityjwt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javamaster.springsecurityjwt.entity.CategoryEntity;
import com.javamaster.springsecurityjwt.service.ICategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/categories")

public class CategoryController {
	@Autowired
	private ICategoryService categoryService;

	@PostMapping
	public ResponseEntity<CategoryEntity> createNewCategory(@RequestBody CategoryEntity category) {
		return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterable<CategoryEntity>> getAllCategory() {
		return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id, @RequestBody CategoryEntity category) {
		Optional<CategoryEntity> categoryOptional = categoryService.findById(id);
		return categoryOptional.map(category1 -> {
			category.setId(category1.getId());
			return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CategoryEntity> deleteCategory(@PathVariable Long id) {
		Optional<CategoryEntity> categoryOptional = categoryService.findById(id);
		return categoryOptional.map(category -> {
			categoryService.remove(id);
			return new ResponseEntity<>(category, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
