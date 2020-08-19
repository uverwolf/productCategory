package com.uverwolf.productocategoria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uverwolf.productocategoria.models.Category;
import com.uverwolf.productocategoria.models.Product;
import com.uverwolf.productocategoria.repositories.CategoryRepository;
import com.uverwolf.productocategoria.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository servicios;
	private final CategoryRepository catServ;
	public ProductService(ProductRepository serv,CategoryRepository servC) {
		this.servicios=serv;
		this.catServ=servC;
	}
	
	public List<Product> verProductos(){
		return servicios.findAll();
	}
	public List<Category> verCategorias(){
		return catServ.findAll();
	}
	public Product crearProducto(Product producto) {
		return servicios.save(producto);
	}
	public Category crearCategoria(Category categoria) {
		return servicios.save(categoria);
	}
	
	public Optional<Product> findById(Long id) {
		
		return servicios.findById(id);
	}
	public Product encontrarProducto(Long id) {
		Optional<Product> producto = servicios.findById(id);
		if(producto.isPresent()) {
			return producto.get();
		}else {
			return null;
		}
	}
	public Category encontrarCategoria(Long id) {
		Optional<Category> categoria = catServ.findById(id);
		if(categoria.isPresent()) {
			return categoria.get();
		}else {
			return null;
		}
	}
	
	
	public List<Category> catAsociadas(Long id){
		
		return catServ.findAllByProductsId(id);
	}
	public List<Product> prodAsociados(Long id){
		
		return servicios.findAllByCategoriesId(id);
	}
	
	public Product agregarCat(Long id,Category categoria) {
		Optional<Product> producto = servicios.findById(id);
		if(producto.isPresent()) {
			producto.get().getCategories().add(categoria);
			
			return servicios.save(producto.get());
		}else {
			return null;
		}
	}
	
	public Category agregarProducto(Long id,Product producto) {
		Optional<Category> categoria = catServ.findById(id);
		if(categoria.isPresent()) {
			categoria.get().getProducts().add(producto);
			
			return servicios.save(categoria.get());
		}else {
			return null;
		}
	}
}
