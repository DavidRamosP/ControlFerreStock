package com.cibertec.FerreStockApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "datos_trabajador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_TRABAJADOR")
	private int id;
	
	@Column(name = "NOMBRE_TRABAJADOR")
	private String nombres;
	
	@Column(name = "APELLIDO_TRABAJADOR")
	private String apellidos;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "CORREO_TRABAJADOR")
	private String email;
	
	@Column(name = "SEXO_TRABAJADOR")
	private String sexo;
	
	@Column(name = "NOMBRE_CARGO")
	private String cargo;
}
