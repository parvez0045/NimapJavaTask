package com.example.StoreProejct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StoreProejct.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
