package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request;

import br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.request.EnderecoRequest;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaRequest {
    @NotNull
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    private List<EnderecoRequest> endereco;

        public List<Endereco> converterEnderecosDeRequest(PessoaRequest pessoaRequest, Pessoa pessoa) {
            List<Endereco> enderecos = pessoaRequest.getEndereco().stream()
                    .map(enderecoRequest -> new Endereco(enderecoRequest, pessoa ))
                    .collect( Collectors.toList());
            return enderecos;
        }
    }
