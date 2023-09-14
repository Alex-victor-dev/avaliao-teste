package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.service;

import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaResponse;

public interface PessoaService {
    PessoaResponse cadastraPessoa(PessoaRequest pessoaRequest);
}
