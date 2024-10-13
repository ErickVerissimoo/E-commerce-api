package com.example.api.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

@Service
public class productService {
	@Autowired
	private productRepository repo;
	@Autowired
	private JdbcTemplate template;
	
	public product produtoRetornar(int id) {
		Optional<product> produto = repo.findById(id);
		return produto.orElseThrow(() ->  new RuntimeException("Produto não encontrado"));
	}
	
	public void Adicionar(product produto) {
		repo.save(produto);
	}
	
	public void atualizar(int id, String nome, float valor) {
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement declaracao = con.prepareStatement("UPDATE produtos set nome = ?, valor = ? where id = ?;");
				declaracao.setString(1, nome);
				declaracao.setFloat(2, valor);
				declaracao.setInt(3, id);
				int linhas =declaracao.executeUpdate();
				System.out.println("Linhas afetadas" + linhas);
				return declaracao;
			}
		});
	}
	
	public void Apagar(int id) {
		String sql = "delete from produtos where id = ?";
		template.update(sql, (ps)-> ps.setInt(1, id));
	}
}