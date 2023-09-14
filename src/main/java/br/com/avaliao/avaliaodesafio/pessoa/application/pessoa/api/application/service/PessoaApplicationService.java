package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.service;

import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.repository.PessoaRepository;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaResponse;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class PessoaApplicationService implements PessoaService {
    private final PessoaRepository pessoaRepository;

    @Override
    public PessoaResponse cadastraPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaApplicationService - cadastraPessoa");
        Pessoa pessoa = pessoaRepository.salvaPessoa(new Pessoa(pessoaRequest));
        log.info("[finaliza] PessoaApplicationService - cadastraPessoa");
        return new PessoaResponse(pessoa);
    }
}
