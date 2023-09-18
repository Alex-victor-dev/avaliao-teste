package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaAlteracaoRequest {
    @NotNull
    private String nome;
}
