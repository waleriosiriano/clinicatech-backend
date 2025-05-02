package com.clinicatech.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "anotações_medicas")
public class AnotacaoMedica {

	@Id
	private String id;
	
	 private String idConsulta; // Relacionamento por referência (id da consulta)
	    private String titulo;
	    private String descricao;
	    private LocalDateTime dataCriacao;
	    
	    public AnotacaoMedica() {
	    	this.dataCriacao = LocalDateTime.now();
	    }
	    
	    public AnotacaoMedica(String idConsulta, String titulo, String descricao) {
	    	this.idConsulta = idConsulta;
	    	this.titulo = titulo;
	    	this.descricao = descricao;
	    	this.dataCriacao = LocalDateTime.now();
	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getIdConsulta() {
			return idConsulta;
		}

		public void setIdConsulta(String idConsulta) {
			this.idConsulta = idConsulta;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public LocalDateTime getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(LocalDateTime dataCriacao) {
			this.dataCriacao = dataCriacao;
		}
	    
}
