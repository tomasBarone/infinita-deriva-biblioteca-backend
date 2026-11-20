package com.libreria.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libreria.dto.PaseLectorRequestDTO;
import com.libreria.event.PaseLectorSolicitadoEvent;

@RestController
@RequestMapping("/api/pase-lector")
public class PaseLectorController {
	
	private final ApplicationEventPublisher eventPublisher;
	
	public PaseLectorController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/solicitar")
    public ResponseEntity<Map<String,String>> solicitarPaseLector(@RequestBody PaseLectorRequestDTO request) {
      
    	String referencia = "SOL-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        eventPublisher.publishEvent(new PaseLectorSolicitadoEvent(referencia, request));

        return ResponseEntity.ok(Map.of(
            "numeroReferencia", referencia,
            "estado", "RECIBIDA"
        ));
    }

}
