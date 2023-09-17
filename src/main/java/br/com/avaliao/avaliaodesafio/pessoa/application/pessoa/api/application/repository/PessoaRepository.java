package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.repository;

import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;

import java.util.List;

public interface PessoaRepository {
    Pessoa salvaPessoa(Pessoa pessoa);

    List<Pessoa> listaPessoas();

    Pessoa buscaPessoaId(Long id);
}
