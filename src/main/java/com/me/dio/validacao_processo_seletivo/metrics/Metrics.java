package com.me.dio.validacao_processo_seletivo.metrics;


import com.me.dio.validacao_processo_seletivo.dto.Candidatos;
import com.me.dio.validacao_processo_seletivo.dto.CandidatosSelecionados;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class Metrics {

    private final ArrayList<String> codigosCandidatos = new ArrayList<>();
    private final MeterRegistry meterRegistry;

    @AfterReturning(
            pointcut = "@annotation(com.me.dio.validacao_processo_seletivo.metrics.annotations.ContarCadastrados)",
            returning = "candidatos"
    )
    public void quantidadeCadastrados(Candidatos candidatos) {
        var qntCandidatos = candidatos.getCandidatos().size();
        var counter = meterRegistry.counter("quantidade_cadastrados", "vaga", "diversos");
        counter.increment(qntCandidatos);
        log.info("[METRIC] {} - Quantidade cadastrados: {}", meterRegistry, qntCandidatos);
    }

    @AfterReturning(
            pointcut = "@annotation(com.me.dio.validacao_processo_seletivo.metrics.annotations.ContarSelecionados)",
            returning = "candidatosSelecionados"
    )
    public void quantidadeSelecionados(CandidatosSelecionados candidatosSelecionados) {
        var qntSelecionados = candidatosSelecionados.getCandidatosSelecionados().size();
        var counter = meterRegistry.counter("quantidade_selecionados", "vaga", "diversos");
        counter.increment(qntSelecionados);
        log.info("[METRIC] {} - Quantidade selecionados: {}", meterRegistry, qntSelecionados);
    }
}
