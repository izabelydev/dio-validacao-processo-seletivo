package com.me.dio.validacao_processo_seletivo.controller;

import com.me.dio.validacao_processo_seletivo.input.Candidato;
import com.me.dio.validacao_processo_seletivo.input.ContatoCandidato;
import com.me.dio.validacao_processo_seletivo.output.Candidatos;
import com.me.dio.validacao_processo_seletivo.output.ResultadoProposta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class PropostaController {

    @GetMapping
    public Candidatos candidatos() {
        ContatoCandidato contato = new ContatoCandidato("joao@email.com", "11912345678");
        ResultadoProposta resultado = new ResultadoProposta("123456", 2000, "CLASSIFICADO", true);
        Candidato candidato = new Candidato("789", "Joao Silva", 2192.3, contato, resultado);
        List<Candidato> candidatos = List.of(candidato);

        return new Candidatos(candidatos);
    }
}
