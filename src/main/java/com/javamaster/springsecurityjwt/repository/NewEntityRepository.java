package com.javamaster.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javamaster.springsecurityjwt.entity.NewEntity;

public interface NewEntityRepository extends JpaRepository<NewEntity, Long> {
}
