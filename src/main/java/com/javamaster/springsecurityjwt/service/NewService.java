package com.javamaster.springsecurityjwt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamaster.springsecurityjwt.entity.CategoryEntity;
import com.javamaster.springsecurityjwt.entity.NewEntity;
import com.javamaster.springsecurityjwt.repository.CategoryEntityRepository;
import com.javamaster.springsecurityjwt.repository.NewEntityRepository;

@Service
public class NewService implements INewService {

	@Autowired
	private NewEntityRepository NewRepository;
	
	@Override
    public Iterable<NewEntity> findAll() {
        return NewRepository.findAll();
    }

    @Override
    public Optional<NewEntity> findById(Long id) {
        return NewRepository.findById(id);
    }

    @Override
    public NewEntity save(NewEntity news) {
        return NewRepository.save(news);
    }

    @Override
    public void remove(Long id) {
    	NewRepository.deleteById(id);
    }
    
//    @Override
//    public NewEntity findAllWithCategory() { 
//    	 return NewRepository.findAllWithCategory();
//    }
    
}
