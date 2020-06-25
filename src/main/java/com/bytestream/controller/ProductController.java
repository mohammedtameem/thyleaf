package com.bytestream.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bytestream.model.Product;
import com.bytestream.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/")
	public String viewHomePage(Model model) {

		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";

	}

	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}

	@PostMapping(value = "/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.add(product);
		return "redirect:/";
	}

}
