package com.me.dio.validacao_processo_seletivo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.me.dio.validacao_processo_seletivo.dto.enums.ResultadoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResultadoProposta {
    private String codigoVaga;
    private double salarioBase;
    private ResultadoEnum resultado;
    private boolean ligar;
}
