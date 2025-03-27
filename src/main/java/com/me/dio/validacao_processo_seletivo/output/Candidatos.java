package com.me.dio.validacao_processo_seletivo.output;

import com.me.dio.validacao_processo_seletivo.input.Candidato;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidatos {
    private List<Candidato> candidatos;
}
