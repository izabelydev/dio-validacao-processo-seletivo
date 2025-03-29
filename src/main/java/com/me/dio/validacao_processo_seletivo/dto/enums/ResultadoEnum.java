package com.me.dio.validacao_processo_seletivo.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultadoEnum {
    CLASSIFICADO (true),
    CONTRA_PROPOSTA (true),
    DESCLASSIFICADO (false);

    private final Boolean id;
}
