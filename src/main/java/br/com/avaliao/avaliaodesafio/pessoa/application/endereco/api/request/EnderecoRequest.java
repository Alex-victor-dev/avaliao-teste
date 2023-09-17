package br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnderecoRequest {
    @NotNull
    private String logradouro;
    @NotNull
    private String cep;
    @NotNull
    private String numero;
    @NotNull
    private String cidade;
}
