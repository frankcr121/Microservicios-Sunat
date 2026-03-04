package com.sunat.recepcion.validador_comprobantes.controller;

import com.sunat.recepcion.validador_comprobantes.model.Comprobante;
import com.sunat.recepcion.validador_comprobantes.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/facturacion")
public class ComprobanteController {

    @Autowired
    private ComprobanteService service;

    @PostMapping("/enviar")
    public Mono<Comprobante> enviar(@RequestBody Comprobante comprobante) {
        return service.procesarComprobante(comprobante);
    }

    @GetMapping("consultar/{serie}/{correlativo}")
    public Mono<Comprobante> consultar(@PathVariable String serie, @PathVariable String correlativo) {
        return service.buscarporSerieYCorrelativo(serie, correlativo);
    }
}