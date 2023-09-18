package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response;

import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaResponse {
    private Long idPessoa;
    private List<EnderecoListResponse> enderecoListResponses;
    public PessoaResponse(Pessoa pessoa, List<Endereco> enderecos) {
        this.idPessoa = pessoa.getId();
        this.enderecoListResponses = EnderecoListResponse.converte(enderecos);

    }
}
