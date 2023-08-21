package com.cibertec.FerreStockApp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "usuario_trabajador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "COD_USUARIO", nullable = false,unique = true)
	private int id;
	
	@Column(name= "USUARIO_TRABAJADOR", nullable = false,unique = true )
	private String username;
	
	@Column(name= "CONTRASEÑA_TRABAJOR", nullable = false)
	private String password;
	
	@Column(name= "FOR_COD_TRABAJADOR")
	private int codTrabajador;
	
	@Column(name= "FOR_COD_TIENDA")
	private int cod_tienda;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_rol",
				joinColumns = @JoinColumn(name = "FOR_COD_USUARIO" , referencedColumnName = "COD_USUARIO"),
				inverseJoinColumns = @JoinColumn(name = "FOR_COD_ROL" , referencedColumnName = "COD_ROL"))
	private List<Rol> roles;

	public Usuario( String username, String password, int codTrabajador , int cod_tienda, List<Rol> roles) {
		this.username = username;
		this.password = password;
		this.codTrabajador = codTrabajador;
		this.cod_tienda = cod_tienda;
		this.roles = roles;
	}
	
	

}
