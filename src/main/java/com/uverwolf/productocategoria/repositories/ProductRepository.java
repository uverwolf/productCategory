package com.uverwolf.productocategoria.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.uverwolf.productocategoria.models.Category;
import com.uverwolf.productocategoria.models.Product;

public interface ProductRepository  extends CrudRepository<Product, Long>{
	List<Product> findAll();
	Category save(Category categoria);
	
	@Query("select products.name from categories inner join categories_products on categories.id = categories_products.category_id inner join products on\r\n" + 
			"products.id = categories_products.product_id where categories.id = ?1 and categories_products.category_id = ?1")
	List<Product> findAllByCategoriesId(Long id);
}
