package com.javamaster.springsecurityjwt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamaster.springsecurityjwt.entity.CategoryEntity;
import com.javamaster.springsecurityjwt.repository.CategoryEntityRepository;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryEntityRepository categoryRepository;
	
	@Override
    public Iterable<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }
	
    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return categoryRepository.save(category);
    }
    
    @Override
    public void remove(Long id) {
    	categoryRepository.deleteById(id);
    }
    
    @Override
    public boolean existsById(Long id) {
    	 return categoryRepository.existsById(id);
    }
    
}
