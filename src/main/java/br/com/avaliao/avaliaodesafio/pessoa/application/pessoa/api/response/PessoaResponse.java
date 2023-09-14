package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response;

import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaResponse {
    private Long idPessoa;
    public PessoaResponse(Pessoa pessoa) {
        this.idPessoa = pessoa.getId();

    }
}
