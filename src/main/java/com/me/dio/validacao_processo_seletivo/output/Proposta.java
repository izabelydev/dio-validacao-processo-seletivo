package com.me.dio.validacao_processo_seletivo.output;

import lombok.*;

@Data
@NoArgsConstructor
public class Proposta {
    private PropostaResposta proposta;

    public Proposta(PropostaResposta proposta) {
        this.proposta = proposta;
    }
}

