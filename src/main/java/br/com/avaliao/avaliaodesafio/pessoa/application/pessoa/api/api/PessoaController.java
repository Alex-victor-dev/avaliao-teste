package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.api;

import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaResponse;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PessoaController implements PessoaAPI {
    private final PessoaService pessoaService;

    @Override
    public PessoaResponse cadastraPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaController - cadastraPessoa");
        PessoaResponse pessoaResponse = pessoaService.cadastraPessoa(pessoaRequest);
        log.info("[finaliza] PessoaController - cadastraPessoa");
        return pessoaResponse;
    }
}
