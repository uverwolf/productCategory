package com.uverwolf.productocategoria.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.uverwolf.productocategoria.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
	
	
	@Query("select categories.name from categories inner join categories_products on categories.id = categories_products.category_id inner join products on\r\n" + 
			"products.id = categories_products.product_id where products.id = ?1 and categories_products.product_id = ?1")
	List<Category> findAllByProductsId(Long id);
		
	
}
