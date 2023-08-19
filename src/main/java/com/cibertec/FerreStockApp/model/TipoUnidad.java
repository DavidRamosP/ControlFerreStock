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
@Table(name = "tb_tipo_unidad_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoUnidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="COD_UND_PRODUC")
	private int id;
	
	@Column(name ="TIPO_UND_PRODUC")
	private String abreviatura;
	
	@Column(name ="NOMBRE_UND_PRODUCTO")
	private String nombre;
	
		
}
