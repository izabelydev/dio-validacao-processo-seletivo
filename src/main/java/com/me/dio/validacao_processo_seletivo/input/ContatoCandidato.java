package com.me.dio.validacao_processo_seletivo.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCandidato {
    private String email;
    private String celular;
}
