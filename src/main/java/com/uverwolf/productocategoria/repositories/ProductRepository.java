package com.uverwolf.productocategoria.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uverwolf.productocategoria.models.Category;
import com.uverwolf.productocategoria.models.Product;

public interface ProductRepository  extends CrudRepository<Product, Long>{
	List<Product> findAll();
	Category save(Category categoria);
}
