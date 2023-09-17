package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.api;

import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.service.PessoaService;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaListResponse;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public List<PessoaListResponse> listaPessoas() {
        log.info("[inicia] PessoaController - listaPessoa");
        List<PessoaListResponse> listaPessoas = pessoaService.listaPessoas();
        log.info("[finaliza] PessoaController - listaPessoa");
        return listaPessoas;
    }
}
