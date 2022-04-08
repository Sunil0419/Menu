package com.trainning.menu.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainning.menu.dto.CategoryDTO;

@Repository
public interface CategoryDAO extends JpaRepository<CategoryDTO, Long> {
	
	Optional<CategoryDTO> findByCategoryId(String categoryId);
}
