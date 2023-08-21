package com.cibertec.FerreStockApp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

	@NotEmpty
	private String nombres;

	@NotEmpty
	private String apellidos;
	
	@NotEmpty
	private String dni;
	@NotEmpty
	private String email;
	@NotEmpty
	private String sexo;
	@NotEmpty
	private String cargo;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
	
	
}
