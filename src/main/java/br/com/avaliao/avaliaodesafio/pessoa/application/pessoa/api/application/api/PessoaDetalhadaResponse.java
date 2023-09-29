package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.api;

import br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.request.EnderecoRequest;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaDetalhadaResponse {
    private String nome;
    private LocalDate dataNascimento;
    private List<EnderecoRequest> endereco;

    public PessoaDetalhadaResponse(Pessoa pessoa, List<Endereco> enderecos) {
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.endereco = EnderecoRequest.converte(enderecos.stream().filter(e -> e.getPessoa()
                .getId() == pessoa.getId()).collect( Collectors.toList()));
    }

}
