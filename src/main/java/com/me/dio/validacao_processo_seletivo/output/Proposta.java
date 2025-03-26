package com.me.dio.validacao_processo_seletivo.output;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.me.dio.validacao_processo_seletivo.input.Candidato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Proposta {
    private Candidato candidato;
    private ResultadoProposta resultadoProposta;
}
