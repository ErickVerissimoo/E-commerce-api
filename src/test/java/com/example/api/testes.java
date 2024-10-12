package com.example.api;



import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.api.Model.product;
import com.example.api.Model.productRepository;
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class testes {
	@Autowired
	private productRepository rep;
	@Test
	void test() throws SQLException {
		product e = new product();
		e.setNome("nescau");
		e.setValor(222);
		rep.save(e);
		
	}

}
