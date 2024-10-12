package com.example.api.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productService {
	@Autowired
	 private productRepository repo;
	
	public product produtoRetornar(int id) {
		var produto = repo.findById(id);
		
		return produto.orElseThrow(() ->  new RuntimeException("Produto não encontrado"));
	}
	public void Adicionar(product produto) {
		repo.save(produto);
	}
}
