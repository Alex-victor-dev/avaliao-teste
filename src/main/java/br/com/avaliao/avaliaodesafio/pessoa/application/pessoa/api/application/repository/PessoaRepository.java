package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.repository;

import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;

public interface PessoaRepository {
    Pessoa salvaPessoa(Pessoa pessoa);
}
