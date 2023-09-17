package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response;

import br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.request.EnderecoRequest;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaListResponse {

    private String nome;
    private LocalDate dataNascimento;
    private List<EnderecoRequest> endereco;

    public PessoaListResponse(Pessoa pessoa, List<Endereco> enderecos) {
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.endereco = EnderecoRequest.converte(enderecos);
    }

    public static List<PessoaListResponse> converte(List<Pessoa> pessoas, List<Endereco> enderecos) {
        return pessoas.stream().map(pessoa -> {
            List<Endereco> enderecosDaPessoa = enderecos.stream()
                    .filter(endereco -> endereco.getPessoa().getId() == pessoa.getId())
                    .collect(Collectors.toList());
            return new PessoaListResponse(pessoa, enderecosDaPessoa);
        }).collect(Collectors.toList());
    }

}
