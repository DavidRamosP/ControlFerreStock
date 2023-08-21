package com.cibertec.FerreStockApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "producto_tienda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoTienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUC_TIENDA")
	private int id;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOR_SKU_PRODUC")
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOR_COD_TIENDA")
	private Tienda tienda;
	
	@Column(name = "STOCK_PRODUC")
	private int stock;
	
}
