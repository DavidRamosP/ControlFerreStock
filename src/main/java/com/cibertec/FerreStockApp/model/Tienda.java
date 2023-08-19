package com.cibertec.FerreStockApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tienda_ferreteria")
@Setter
@Getter
@NoArgsConstructor
public class Tienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "COD_TIENDA")
	private int id;
	
	@Column(name = "RUC_TIENDA" , nullable = false, unique = true)
	private String ruc;
	
	@Column(name = "NOMBRE_TIENDA", nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "DIRECCION_TIENDA", nullable = false)
	private String direccion;
	
}
