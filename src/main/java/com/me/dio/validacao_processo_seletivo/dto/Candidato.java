package com.me.dio.validacao_processo_seletivo.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Candidato {
    private String codigoCandidato;
    private String nomeCandidato;
    private double salarioPretendido;
    private ContatoCandidato contatoCandidato;
}
