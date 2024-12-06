package com.example.StoreProejct.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StoreProejct.Service.CategoryService;
import com.example.StoreProejct.entity.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// Get all categories with pagination
	@GetMapping
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return categoryService.getAllCategories(PageRequest.of(page, size));
	}

	// Get category by ID
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
//	 create a new category
	 @PostMapping
	 public Category createCategory(@RequestBody Category category) {
		 return categoryService.saveCategory(category);
	 }
	 
//	 update category by ID
	 @PutMapping("/{id}")
	 public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
		 return categoryService.updateCategory(id, categoryDetails);
	 }
	 
//	 delete category by ID
	 @DeleteMapping("/{id}")
	 public void deleteCategory(@PathVariable Long id) {
	        categoryService.deleteCategory(id);
	 }
}
