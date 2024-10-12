package com.example.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Model.product;
import com.example.api.Model.productService;

@RestController
public class indexRest {
	@Autowired
	private productService producto;
	
@GetMapping("/produto")
public product produto(@RequestParam(required = true) String id) {
	int ID = Integer.parseInt(id);
	
	return producto.produtoRetornar(ID);
}
@PostMapping("/Adicionar")
public ResponseEntity<String> Adicionar(@RequestParam(name = "valor") float valor, @RequestParam(name = "nome") String nome) {
	product produtu = new product();
	produtu.setValor(valor);
	produtu.setNome(nome);
	producto.Adicionar(produtu);
	return new ResponseEntity<>("Produto adicionado", HttpStatus.CREATED);
	
}
}
