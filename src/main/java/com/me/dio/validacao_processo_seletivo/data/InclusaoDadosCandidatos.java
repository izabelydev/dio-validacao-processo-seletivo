package com.me.dio.validacao_processo_seletivo.data;

import com.me.dio.validacao_processo_seletivo.dto.Candidato;
import com.me.dio.validacao_processo_seletivo.dto.CandidatoSelecionado;
import com.me.dio.validacao_processo_seletivo.dto.ContatoCandidato;
import com.me.dio.validacao_processo_seletivo.dto.ResultadoProposta;
import com.me.dio.validacao_processo_seletivo.dto.enums.ResultadoEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class InclusaoDadosCandidatos {

    private Double obterSalarioPretendido() {
        var valor = String.format(Locale.US,"%.2f", ThreadLocalRandom.current().nextDouble(1500, 2500));
        return Double.valueOf(valor);
    }

    private <T> T popularCampo(int i, List<T> lista) {
        if (lista != null && !lista.isEmpty() && i < lista.size()) {
            return lista.get(i);
        } else return null;
    }

    public ArrayList<Candidato> popularDadosCandidato(ArrayList<String> nomes, ArrayList<String> emails,
                                                      ArrayList<String> celulares) {
        var candidatosLista = new ArrayList<Candidato>();

        int tamanhoLista = Math.max(
                nomes != null ? nomes.size() : 0,
                Math.max(emails != null ? emails.size() : 0, celulares != null ? celulares.size() : 0)
        );

        for(int i = 0; i < tamanhoLista; i++) {
            var candidato = new Candidato();
            var contatoCandidato = new ContatoCandidato();
            var codCandidato = String.valueOf(UUID.randomUUID());

            candidato.setSalarioPretendido(obterSalarioPretendido());
            candidato.setContatoCandidato(contatoCandidato);
            candidato.setCodigoCandidato(codCandidato);

            candidato.setNomeCandidato(popularCampo(i, nomes));
            contatoCandidato.setCelular(popularCampo(i, celulares));
            contatoCandidato.setEmail(popularCampo(i, emails));

            candidatosLista.add(candidato);
        }
        return candidatosLista;
    }

    private ResultadoEnum avaliarCandidato(List<Candidato> candidatos, int i) {
        var salarioBase = 2000.0;
        var salarioPretendido = candidatos.get(i).getSalarioPretendido();

        if(salarioBase > salarioPretendido) return ResultadoEnum.CLASSIFICADO;
        else if(salarioBase == salarioPretendido) return ResultadoEnum.CONTRA_PROPOSTA;
        else return ResultadoEnum.DESCLASSIFICADO;
    }

    /**
     * @ultimoCandidato usado para particionar a lista de candidatos
     */
    private int ultimoCandidato;
    private ArrayList<CandidatoSelecionado> candidatosLista = new ArrayList<>();

    public List<CandidatoSelecionado> popularDadosCandidatoSelecionado(List<Candidato> candidatos) {
        if (candidatos == null || candidatos.isEmpty()) return null;

        var tamanhoLista = candidatos.size();
        var particao = Math.min(ultimoCandidato + 5, tamanhoLista);

        for (int i = ultimoCandidato; i < particao; i++) {
            var candidatoSelecionado = new CandidatoSelecionado();
            var avaliacao = avaliarCandidato(candidatos, i);

            if (avaliacao.getId()) {
                var resultadoProposta = new ResultadoProposta();

                candidatoSelecionado.setCandidato(popularCampo(i, candidatos));
                candidatoSelecionado.setResultadoProposta(resultadoProposta);
                resultadoProposta.setResultado(avaliacao);
                resultadoProposta.setLigar(true);
                resultadoProposta.setSalarioBase(2000);

                this.candidatosLista.add(candidatoSelecionado);
            }
            // o modulo % faz i sempre voltar para 0 quando ultrapassar o tamanho da lista (loop infinito)
            // ultimoCandidato = (i + 1) % tamanhoLista;
            ultimoCandidato = i;
        }

        if (ultimoCandidato >= tamanhoLista) {
            log.info("[INFO] Todos os candidatos foram processados. Total: {}", tamanhoLista);
            ultimoCandidato = 0; // Reinicie se necessário
        } else {
            log.info("[INFO] Ultimo candidato: {}", ultimoCandidato);
        }

        return this.candidatosLista;
    }
}
