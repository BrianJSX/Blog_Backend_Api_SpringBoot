package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.entity.CategoryEntity;

public interface ICategoryService extends  IGeneralService<CategoryEntity> {

	boolean existsById(Long categoryId);
}
