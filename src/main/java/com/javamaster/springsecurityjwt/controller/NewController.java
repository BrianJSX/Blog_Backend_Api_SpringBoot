package com.javamaster.springsecurityjwt.controller;

import java.util.Optional;

import javax.validation.Valid;

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
import com.javamaster.springsecurityjwt.entity.NewEntity;
import com.javamaster.springsecurityjwt.repository.CategoryEntityRepository;
import com.javamaster.springsecurityjwt.service.ICategoryService;
import com.javamaster.springsecurityjwt.service.INewService;

@RestController
@CrossOrigin("*")
@RequestMapping
public class NewController {
	@Autowired
	private INewService newService;
	@Autowired
	private ICategoryService categoryService;

	@PostMapping("/admin/{categoryid}/news")
	public ResponseEntity<NewEntity> createNews(@PathVariable Long categoryid, @RequestBody NewEntity news) {

		Optional<CategoryEntity> categoryOptional = categoryService.findById(categoryid);

		return categoryOptional.map(category -> {
			news.setCategory(category);
			return new ResponseEntity<NewEntity>(newService.save(news), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<NewEntity>(HttpStatus.BAD_REQUEST));
	}

	@GetMapping("/admin/news")
	public ResponseEntity<Iterable<NewEntity>> getAllNews() {
		return new ResponseEntity<>(newService.findAll(), HttpStatus.OK);
	}

	@PutMapping("/admin/{categoryId}/news/{newsId}")
	public ResponseEntity<NewEntity> updateNews(@PathVariable (value = "categoryId") Long categoryId,
			 									@PathVariable (value = "newsId") Long newsId,
												@RequestBody NewEntity news) {
		
		if(!categoryService.existsById(categoryId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		
		Optional<CategoryEntity> categoryOptional = categoryService.findById(categoryId);

		return categoryOptional.map(category -> {
			news.setId(newsId);
			news.setCategory(category);
			return new ResponseEntity<NewEntity>(newService.save(news), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<NewEntity>(HttpStatus.BAD_REQUEST));
	}

	@DeleteMapping("/admin/news/{id}")
	public ResponseEntity<NewEntity> deleteNews(@PathVariable Long id) {
		Optional<NewEntity> newsOptional = newService.findById(id);
		return newsOptional.map(news -> {
			newService.remove(id);
			return new ResponseEntity<>(news, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
