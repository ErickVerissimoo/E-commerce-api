package com.example.api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
@Table("produtos")
@Data
public class product {
	private String nome;
	private float valor;
	@Id
	private Integer id;

}
