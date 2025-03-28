package com.me.dio.validacao_processo_seletivo.data;

import com.me.dio.validacao_processo_seletivo.dto.Candidato;
import com.me.dio.validacao_processo_seletivo.dto.CandidatoSelecionado;
import com.me.dio.validacao_processo_seletivo.dto.ContatoCandidato;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InclusaoDadosCandidatos {
    public List<Candidato> popularDadosCandidato(List<String> nomes, List<String> emails, List<String> celulares) {

        ArrayList<Candidato> candidatosLista = new ArrayList<>();

        for(int i = 0; i < nomes.size(); i++) {
            var candidato = new Candidato();
            var contatoCandidato = new ContatoCandidato();
            var codCandidato = String.valueOf(UUID.randomUUID());

            candidato.setCodigoCandidato(codCandidato);
            candidato.setNomeCandidato(nomes.get(i));
            candidato.setContatoCandidato(contatoCandidato);
            contatoCandidato.setCelular(celulares.get(i));
            contatoCandidato.setEmail(emails.get(i));
            candidatosLista.add(candidato);
        }
        return candidatosLista;
    }

    public List<CandidatoSelecionado> popularDadosCandidatoSelecionado(List<String> nomes, List<String> emails, List<String> celulares) {

        ArrayList<Candidato> candidatosSelecionadosLista = new ArrayList<>();

        return null;
    }
}
