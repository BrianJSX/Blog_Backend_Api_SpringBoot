package com.javamaster.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javamaster.springsecurityjwt.entity.CategoryEntity;
import com.javamaster.springsecurityjwt.entity.RoleEntity;
import com.javamaster.springsecurityjwt.entity.UserEntity;

@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {
	boolean existsById(long id);
}
