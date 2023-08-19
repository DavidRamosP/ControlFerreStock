package com.cibertec.FerreStockApp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
	
	@Id
	@Column(name = "COD_ROL", nullable = false,unique = true)
	private int id;
	
	@Column(name = "NOMBRE_ROL", nullable = false,unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;

	public Rol(String name, List<Usuario> usuarios) {
		super();
		this.name = name;
		this.usuarios = usuarios;
	}

	public Rol(String name) {
		this.name = name;
	}

	
	
}


