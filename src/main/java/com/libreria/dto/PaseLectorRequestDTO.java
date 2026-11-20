package com.libreria.dto;

public class PaseLectorRequestDTO {
	
	private String nombreCompleto;
	private String email;
	private String documento;
	private String direccion;
	private String ciudad;
	private String codigoPostal;
	private String categoriaLector;
	private String sedePreferida;
	
	public PaseLectorRequestDTO() {
		
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCategoriaLector() {
		return categoriaLector;
	}

	public void setCategoriaLector(String categoriaLector) {
		this.categoriaLector = categoriaLector;
	}

	public String getSedePreferida() {
		return sedePreferida;
	}

	public void setSedePreferida(String sedePreferida) {
		this.sedePreferida = sedePreferida;
	}
	
	

}
