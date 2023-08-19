package com.cibertec.FerreStockApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SKU_PRODUC")
	private int sku;
	
	@Column(name = "NOMBRE_PRODUC")
	private String nombre;
	
	@Column(name = "PRECIO_PRODUC")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name = "FOR_COD_PROVEEDOR")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "FOR_COD_UND")
	private TipoUnidad unidad;
	
	
}
