package com.libreria.event;

import com.libreria.dto.PaseLectorRequestDTO;

public class PaseLectorSolicitadoEvent {
	
	private final String numeroReferencia;
	private final PaseLectorRequestDTO solicitud;
	
	public PaseLectorSolicitadoEvent(String numeroReferencia, PaseLectorRequestDTO solicitud) {
		this.numeroReferencia = numeroReferencia;
		this.solicitud = solicitud;
		
	}

	public String getNumeroReferencia() {
		return numeroReferencia;
		
	}
	
	public PaseLectorRequestDTO getSolicitud() {
		return solicitud;
	}
	
}
