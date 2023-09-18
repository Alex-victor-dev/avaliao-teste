package br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.application.repository;

import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;

import java.util.List;

public interface EnderecoRepository {
    List<Endereco> listaEnderecosDaPessoa();

    void salvaEnderecosAsociadoApessoa(List<Endereco> enderecos);
}
