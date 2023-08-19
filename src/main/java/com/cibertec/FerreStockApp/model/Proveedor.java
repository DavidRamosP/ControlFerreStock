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
@Table(name="proveedor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_PROVEEDOR")
	private int id;
	
	@Column(name = "RUC_PROVEEDOR" , nullable = false, unique = true)
	private String ruc;
	
	@Column(name = "NOMBRE_PROVEEDOR", nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "MARCA_PROVEEDOR", nullable = false, unique = true)
	private String marca;
}
