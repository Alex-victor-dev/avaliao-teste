package br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.request;

import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

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

    public EnderecoRequest(Endereco endereco) {
        this.logradouro = endereco.getLogradouro();
        this.cep = endereco.getCep();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
    }

    public static List<EnderecoRequest> converte(List<Endereco> enderecos) {
        return enderecos.stream().map(EnderecoRequest::new).collect( Collectors.toList());
    }
}
