package com.me.dio.validacao_processo_seletivo.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidatos {
    private List<Candidato> candidatos;
}
