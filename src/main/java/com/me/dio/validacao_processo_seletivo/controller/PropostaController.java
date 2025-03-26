package com.me.dio.validacao_processo_seletivo.controller;

import com.me.dio.validacao_processo_seletivo.input.Candidato;
import com.me.dio.validacao_processo_seletivo.input.ContatoCandidato;
import com.me.dio.validacao_processo_seletivo.output.Proposta;
import com.me.dio.validacao_processo_seletivo.output.ResultadoProposta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class PropostaController {

    @GetMapping
    public Proposta proposta() {
        ContatoCandidato contato = new ContatoCandidato("joao@email.com", "11912345678");

        Candidato candidato = new Candidato(
                "123456",
                "789",
                "Joao Silva",
                2192.3,
                contato
        );

        ResultadoProposta resultado = new ResultadoProposta(2000, "CLASSIFICADO", true);

        return new Proposta(candidato, resultado);
    }
}
