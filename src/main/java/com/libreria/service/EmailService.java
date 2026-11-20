package com.libreria.service;

import com.libreria.dto.PaseLectorRequestDTO;
import com.libreria.model.Orden;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    private static final String DESTINATARIO_ARCHIVO = "tomas.barone.dev@gmail.com";

    private final Resend resend;
    private final TemplateEngine templateEngine;

    public EmailService(@Value("${resend.api.key}") String apiKey, TemplateEngine templateEngine) {
        this.resend = new Resend(apiKey);
        this.templateEngine = templateEngine;
    }

    public void enviarConfirmacionCompra(Orden orden) {
        Context context = new Context();
        context.setVariable("orden", orden);
        context.setVariable("detalles", orden.getDetalles());

        String htmlContent = templateEngine.process("mail/confirmacion-compra", context);

        CreateEmailOptions params = CreateEmailOptions.builder()
            .from("onboarding@resend.dev")
            .to(DESTINATARIO_ARCHIVO)
            .subject("Confirmación de Solicitud Bibliográfica #" + orden.getId())
            .html(htmlContent)
            .build();

        try {
            resend.emails().send(params);
        } catch (ResendException e) {
            throw new RuntimeException("Error al enviar email mediante Resend: " + e.getMessage(), e);
        }
    }

    public void enviarSolicitudPaseLector(String referencia, PaseLectorRequestDTO solicitud) {
        Context context = new Context();
        context.setVariable("referencia", referencia);
        context.setVariable("solicitud", solicitud);

        String htmlContent = templateEngine.process("mail/solicitud-pase-lector", context);

        CreateEmailOptions params = CreateEmailOptions.builder()
            .from("onboarding@resend.dev")
            .to(DESTINATARIO_ARCHIVO)
            .replyTo(solicitud.getEmail())
            .subject("Solicitud de Pase Lector [" + referencia + "] - " + solicitud.getNombreCompleto())
            .html(htmlContent)
            .build();

        try {
            resend.emails().send(params);
        } catch (ResendException e) {
            throw new RuntimeException("Error al enviar solicitud de Pase Lector mediante Resend: " + e.getMessage(), e);
        }
    }
}