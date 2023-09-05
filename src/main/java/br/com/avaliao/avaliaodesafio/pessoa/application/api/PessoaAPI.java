package br.com.avaliao.avaliaodesafio.pessoa.application.api;


import br.com.avaliao.avaliaodesafio.pessoa.application.api.request.PessoaRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.api.response.PessoaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/pessoa")
public interface PessoaAPI {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PessoaResponse cadastraPessoa(@RequestBody PessoaRequest pessoaRequest);
}
