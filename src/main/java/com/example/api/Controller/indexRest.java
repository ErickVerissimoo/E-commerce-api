package com.example.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.Model.product;
import com.example.api.Model.productService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@RestController
public class indexRest {
	@Autowired
	private productService producto;

@GetMapping("/produto")
public ResponseEntity<String> produto(@RequestParam(name = "id") String id) {
	int ID = Integer.parseInt(id);
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	var e= producto.produtoRetornar(ID);
	return new ResponseEntity<>(gson.toJson(e), HttpStatus.ACCEPTED);
}
@PostMapping("/Adicionar")
public ResponseEntity<String> Adicionar(@RequestParam(name = "valor") String valor, @RequestParam(name = "nome") String nome) {
	product produtu = new product();
	produtu.setValor(Float.parseFloat(valor));
	produtu.setNome(nome);
	producto.Adicionar(produtu);
	return new ResponseEntity<>("Produto adicionado", HttpStatus.CREATED);

}

@PutMapping("/atualizar")
public ResponseEntity<String> att (@RequestParam(name = "valor") String valor, @RequestParam(name = "nome") String nome, @RequestParam(name = "id") String id){
	producto.atualizar(Integer.parseInt(id), nome, Float.parseFloat(valor));
	
	return new ResponseEntity<>("Produto atualizado", HttpStatus.OK);
}
}
