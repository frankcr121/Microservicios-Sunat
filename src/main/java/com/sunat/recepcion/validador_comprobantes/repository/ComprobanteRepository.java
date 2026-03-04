package com.sunat.recepcion.validador_comprobantes.repository;

import com.sunat.recepcion.validador_comprobantes.model.Comprobante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ComprobanteRepository extends ReactiveMongoRepository<Comprobante, String> {
    Mono<Comprobante> findBySerieAndCorrelativo(String serie, String correlativo);
}

