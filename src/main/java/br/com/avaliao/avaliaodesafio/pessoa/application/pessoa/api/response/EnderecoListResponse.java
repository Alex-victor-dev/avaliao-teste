package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response;

import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnderecoListResponse {
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    public static List<EnderecoListResponse> converte(List<Endereco> enderecos) {
        return enderecos.stream().map(EnderecoListResponse::new).collect( Collectors.toList());
    }

    public EnderecoListResponse(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
    }
}
