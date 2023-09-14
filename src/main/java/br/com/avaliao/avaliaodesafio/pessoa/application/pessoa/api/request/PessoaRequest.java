package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request;

import br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.request.EnderecoRequest;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaRequest {
    private String nome;
    private LocalDate dataNascimento;
    private List<EnderecoRequest> endereco;
}
