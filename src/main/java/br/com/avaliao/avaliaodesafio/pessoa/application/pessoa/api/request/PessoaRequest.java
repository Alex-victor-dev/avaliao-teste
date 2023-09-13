package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request;

import br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.request.EnderecoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PessoaRequest {
    private String nome;
    private LocalDate dataNascimento;
    private List<EnderecoRequest> endereco;
}
