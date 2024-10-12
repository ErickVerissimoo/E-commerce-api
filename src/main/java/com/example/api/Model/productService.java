package com.example.api.Model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productService {
	@Autowired
	 private productRepository repo;

	public product produtoRetornar(int id) {
		Optional<product> produto = repo.findById(id);

		return produto.orElseThrow(() ->  new RuntimeException("Produto não encontrado"));
	}
	public void Adicionar(product produto) {
		repo.save(produto);
	}
}
