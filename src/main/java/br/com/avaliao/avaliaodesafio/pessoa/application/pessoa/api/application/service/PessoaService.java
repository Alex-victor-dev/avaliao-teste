package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.service;

import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.api.PessoaDetalhadaResponse;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaAlteracaoRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaListResponse;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaResponse;

import java.util.List;

public interface PessoaService {
    PessoaResponse cadastraPessoa(PessoaRequest pessoaRequest);

    List<PessoaListResponse> listaPessoas();

    void alteraPessoa(PessoaAlteracaoRequest pessoaAlteracaoRequest, Long id);

    PessoaDetalhadaResponse detalhaPessoaPorId(Long id);
}
