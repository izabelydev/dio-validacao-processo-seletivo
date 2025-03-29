package com.me.dio.validacao_processo_seletivo.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.dio.validacao_processo_seletivo.dto.Candidatos;
import com.me.dio.validacao_processo_seletivo.dto.CandidatosSelecionados;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class InclusaoCandidatos {

    /**
     * Inicializacao automatica da classe:
     *
     * @Component O Spring detecta a classe automaticamente durante a inicializacao e cria uma
     * instância única (um bean) dela, gerenciando o seu ciclo de vida.
     *
     * @PostConstruct Executa automaticamente o metodo na inicializacao.
     *
     * @Motivo
     * O metodo selecionarCandidatos depende dos dados que o metodo cadastrarCandidatos gera. Para evitar nullPointer,
     * ter alta disponibilidade das informacoes e velocidade de processamento é ideal que os dados estejam disponiveis
     * assim que o processo inicia.
     */

    private Candidatos candidatos = new Candidatos();
    private CandidatosSelecionados candidatosSelecionados = new CandidatosSelecionados();
    private InclusaoDadosCandidatos inclusaoDadosCandidatos = new InclusaoDadosCandidatos();

    @PostConstruct
    private void iniciar() {cadastrarCandidatos(); selecionarNovosCandidatos();}

    public Object cadastrarCandidatos() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode dadosJson = mapper.readTree(new File("src/main/resources/data/candidatos_gerados_ia.json"));
            ArrayList<String> nomes, emails, celulares;

            nomes = mapper.convertValue(dadosJson.get("nome_candidato"), ArrayList.class);
            emails = mapper.convertValue(dadosJson.get("email"), ArrayList.class);
            celulares = mapper.convertValue(dadosJson.get("celular"), ArrayList.class);

            this.candidatos.setCandidatos(inclusaoDadosCandidatos.popularDadosCandidato(nomes, emails, celulares));

            log.info("[INFO] Dados dos {} candidatos processados e cadastrados com sucesso",
                    this.candidatos.getCandidatos().size());

        } catch (Exception e) {
            log.error("[ERRO] Nao foi possivel processar dados dos candidatos: ", e);
            this.candidatos.setCandidatos(null);
            throw new RuntimeException(e);
        }

        return this.candidatos;
    }

    public Object selecionarNovosCandidatos() {
        try {
            var candidatoLista = inclusaoDadosCandidatos.popularDadosCandidatoSelecionado(this.candidatos.getCandidatos());
            this.candidatosSelecionados.setCandidatosSelecionados(candidatoLista);
//            log.info("[INFO] 5 candidatos dos {} candidatos cadastrados foram selecionados com sucesso",
//                    this.candidatos.getCandidatos().size());

        } catch (Exception e) {
            log.error("[ERRO] Nao foi possivel processar candidatos a serem selecionados: ", e);
            this.candidatosSelecionados.setCandidatosSelecionados(null);
            throw new RuntimeException(e);
        }

        return this.candidatosSelecionados;
    }
}
