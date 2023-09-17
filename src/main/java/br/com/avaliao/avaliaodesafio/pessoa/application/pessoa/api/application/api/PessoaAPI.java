package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.api;


import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaAlteracaoRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaListResponse;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/pessoa")
public interface PessoaAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PessoaResponse cadastraPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PessoaListResponse> listaPessoas();

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void alteraPessoa(@Valid @RequestBody PessoaAlteracaoRequest pessoaAlteracaoRequest,
                      @PathVariable Long id);

}
