package com.me.dio.validacao_processo_seletivo.controller;

import com.me.dio.validacao_processo_seletivo.data.InclusaoCandidatos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CandidatosController {

    private final InclusaoCandidatos inclusaoCandidatos;

    // Injeção de dependência pelo construtor para que a inclusao de candidatos instancie e inicie automaticamente
    public CandidatosController(InclusaoCandidatos inclusaoCandidatos) {
        this.inclusaoCandidatos = inclusaoCandidatos;
    }

    @GetMapping("/candidatos-cadastrados")
    public Object candidatos() {
        return inclusaoCandidatos.getCandidatos();
    }

    @GetMapping("/selecionar-novos-selecionados")
    public Object novosCandidatosSelecionados() {
        return inclusaoCandidatos.selecionarNovosCandidatos();
    }

    @GetMapping("/candidatos-selecionados")
    public Object candidatosSelecionados() {
        return inclusaoCandidatos.getCandidatosSelecionados();
    }
}
