package com.uverwolf.productocategoria.controllers;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.uverwolf.productocategoria.models.Category;
import com.uverwolf.productocategoria.models.Product;
import com.uverwolf.productocategoria.services.ProductService;

@Controller
public class ProductosController {
	private final ProductService servicios;
	public ProductosController(ProductService serv) {
		this.servicios=serv;
	}
	@GetMapping("/index")
	public String index() {
		return "/vistas/index.jsp";
	}
	
	@GetMapping("/products")
	public String productos(@ModelAttribute("productoValido") Product producto ) {
		return "/vistas/productos.jsp";
	}
	
	@PostMapping("/products")
	public String crearProductos(@Valid @ModelAttribute("productoValido")Product producto) {
		servicios.crearProducto(producto);
		return "redirect:/index";
	}
	
	@GetMapping("/categories")
	public String categorias(@ModelAttribute("categoriaValida") Category categoria) {
		return "/vistas/categorias.jsp";
	}
	@PostMapping("/categories")
	public String creaCategoria(@Valid @ModelAttribute("categoriaValida")Category categoria) {
		servicios.crearCategoria(categoria);
		return "redirect:/index";
	}
	//LISTAR PRODUCTOS
	@GetMapping("/products/ver")
	public String listadoProd (Model modelo) {
			modelo.addAttribute("productos", servicios.verProductos());
			return "vistas/verProductos.jsp";
	}
	//Listar Categorias
	@GetMapping("/categories/ver")
	public String listadoCat(Model modelo) {
			modelo.addAttribute("categorias", servicios.verCategorias());
			return "vistas/verCategorias.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String agregarCatProd( @ModelAttribute("catValida")Category categ,@PathVariable("id") Long id, Model modelo) {
		Product productoE= servicios.encontrarProducto(id);
		modelo.addAttribute("producto",productoE);
		modelo.addAttribute("categorias", servicios.verCategorias());
		modelo.addAttribute("catAsociadas",servicios.catAsociadas(id));
		return "vistas/agregarCat.jsp";
	}
	
	
	@PostMapping("/products/{id}")
	public String agregarCATEGORIA(@ModelAttribute("catValida")Category catego, @PathVariable("id")Long id) {
		
		servicios.agregarCat(id, catego);
		return "redirect:/products/"+id;
	}
	
	
	
	
	
	
}
