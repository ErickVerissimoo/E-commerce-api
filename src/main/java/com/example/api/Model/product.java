package com.example.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import lombok.Data;
@Table("PRODUTOS")
@Data
public class product {
	private String nome;
	private float valor;
	@Id
	private Integer id;
	
}
