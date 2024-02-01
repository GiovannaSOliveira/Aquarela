package com.generation.aquarela.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonIgnoreProperties ("produto")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties ("produto")
	private Usuario usuario;
	
	@NotBlank
	@Size (min = 5, max = 100, message = "O nome da postagem deve ter entre 5 e 100 caracteres.")
	private String nome;
	
	@Size (min = 5, max = 300, message = "A descrição do produto deve ter de 5 a 300 caracteres.")
	private String descricao;
	
	@Size(min = 2, max = 100, message = "Material deve conter no mínimo 2 caracteres e no máximo 100 caracteres!")
	private String material;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "Preço é obrigatório.")
	@Positive(message = "O preço deve ter valor positivo.")
	private BigDecimal preco;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
	private String foto;
	
	//getters e setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}	
}