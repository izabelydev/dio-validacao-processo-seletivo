package com.me.dio.validacao_processo_seletivo.controller;

import com.me.dio.validacao_processo_seletivo.data.InclusaoCandidatos;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class CandidatosController {
    /**
     * @AllArgsConstructor
     * Injeção de dependência pelo construtor para que a classe inclusaoCandidatos instancie e inicie automaticamente.
     */

    private final InclusaoCandidatos inclusaoCandidatos;

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
