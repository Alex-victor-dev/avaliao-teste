package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.service;

import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class PessoaApplicationService implements PessoaService {
    @Override
    public PessoaResponse cadastraPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaApplicationService - cadastraPessoa");

        log.info("[finaliza] PessoaApplicationService - cadastraPessoa");
        return null;
    }
}
