package com.sunat.recepcion.validador_comprobantes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "comprobantes")
public class Comprobante {
    @Id
    private String id;
    private String rucEmisor;
    private String serie;
    private String correlativo;
    private Double monto;
    private String estado;
    private String firmaDigital;
}