package com.generation.aquarela.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table (name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = " O Tipo é obrigatório! ")
	@Size(min = 3, max = 100, message = "O Tipo de produto deve conter no mínimo 03 caracteres e no máximo 100 caracteres!")
	private String tipo;
	
	@NotBlank (message = " A Descrição do produto é obrigatória! ")
	@Size(min = 20, max = 100, message = "Adicione a descrição do produto que deve conter no mínimo 20 caracteres e no máximo 100 caracteres!")
	private String descricaocat;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("categoria")
    private List<Produto> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricaocat() {
		return descricaocat;
	}

	public void setDescricaocat(String descricaocat) {
		this.descricaocat = descricaocat;
	}
	
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	 
}
