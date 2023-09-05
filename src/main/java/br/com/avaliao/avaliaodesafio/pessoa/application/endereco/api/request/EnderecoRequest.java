package br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnderecoRequest {
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
}
