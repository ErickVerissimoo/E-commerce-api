package com.example.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@ResponseBody
public ResponseEntity<String> produto(@RequestParam(name = "id") String id) {
	try{
		int ID = Integer.parseInt(id);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		var e= producto.produtoRetornar(ID);
		return new ResponseEntity<>(gson.toJson(e), HttpStatus.ACCEPTED);
	} catch(NumberFormatException ex)  {
		System.out.print(ex.getCause());
		return new ResponseEntity<String>("O parametro passado não é um inteiro positivo", HttpStatus.BAD_REQUEST);
	}
}
@PostMapping("/Adicionar")
@ResponseBody
public ResponseEntity<String> Adicionar(@RequestParam(name = "valor") String valor, @RequestParam(name = "nome") String nome) {
	product produtu = new product();
	produtu.setValor(Float.parseFloat(valor));
	produtu.setNome(nome);
	producto.Adicionar(produtu);
	return new ResponseEntity<>("Produto adicionado", HttpStatus.CREATED);
}

@PutMapping("/atualizar")
@ResponseBody
public ResponseEntity<String> att (@RequestParam(name = "valor") String valor, @RequestParam(name = "nome") String nome, @RequestParam(name = "id") String id){
	try {
	producto.atualizar(Integer.parseInt(id), nome, Float.parseFloat(valor));
	return new ResponseEntity<>("Produto atualizado", HttpStatus.OK);
	} catch(NumberFormatException excecao) {
		return new ResponseEntity<>("Id ou valor passados incorretamente", HttpStatus.BAD_REQUEST); 
	}
}
@DeleteMapping("/Deletar")
@ResponseBody
public ResponseEntity<String> apagar(@RequestParam(name = "id") String id){
	producto.Apagar(Integer.parseInt(id));
	return new ResponseEntity<>("Item apagado", HttpStatus.ACCEPTED);
}
}