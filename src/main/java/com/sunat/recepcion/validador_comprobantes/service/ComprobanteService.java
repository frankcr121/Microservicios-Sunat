package com.sunat.recepcion.validador_comprobantes.service;

import com.sunat.recepcion.validador_comprobantes.model.Comprobante;
import com.sunat.recepcion.validador_comprobantes.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ComprobanteService {

    @Autowired
    private ComprobanteRepository repository;

    public Mono<Comprobante> procesarComprobante(Comprobante comprobante) {
        return Mono.just(comprobante)
                .map(c -> {
                    if (c.getMonto() <= 0) {
                        throw new RuntimeException("Monto inválido");
                    }
                    if(c.getRucEmisor() == null || c.getRucEmisor().matches("^(10|20)\\\\d{9}$")){
                        throw new RuntimeException("RUC inválido: debe tener 11 dígitos y empezar con 10 o 20");
                    }
                    if (c.getFirmaDigital() == null || !c.getFirmaDigital().startsWith("SUNAT-") || c.getFirmaDigital().length() < 20) {
                        throw  new RuntimeException("Firma digital invalida");

                    }
                    c.setEstado("VALIDADO");
                    return c;
                })
                .flatMap(repository::save)
                .doOnNext(c -> System.out.println("[SUNAT LOG] Procesado: " + c.getSerie()))
                .onErrorResume(e -> {
                    comprobante.setEstado("RECHAZADO");
                    return Mono.just(comprobante);
                });
    }

    public Mono<Comprobante> buscarporSerieYCorrelativo(String serie, String correlativo) {
        return repository.findBySerieAndCorrelativo(serie, correlativo)
                .switchIfEmpty(Mono.error(new RuntimeException("Comprobante no encontrado en los registros de la SUNAT")));
    }

}