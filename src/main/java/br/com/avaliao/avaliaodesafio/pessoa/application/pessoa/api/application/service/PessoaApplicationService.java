package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.service;

import br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.application.repository.EnderecoRepository;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.repository.PessoaRepository;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaListResponse;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.response.PessoaResponse;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class PessoaApplicationService implements PessoaService {
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;

    @Override
    public PessoaResponse cadastraPessoa(PessoaRequest pessoaRequest) {
        log.info("[inicia] PessoaApplicationService - cadastraPessoa");
        Pessoa pessoa = (new Pessoa(pessoaRequest));
        List<Endereco> enderecos = pessoaRequest.getEndereco().stream()
                .map(enderecoRequest -> new Endereco(enderecoRequest, pessoa))
                .collect( Collectors.toList());
        pessoa.relacionaEndereco(enderecos);
        pessoaRepository.salvaPessoa(pessoa);
        enderecoRepository.salvaEnderecosAsociadoApessoa(pessoa.getEnderecos());
        log.info("[finaliza] PessoaApplicationService - cadastraPessoa");
        return new PessoaResponse(pessoa, pessoa.getEnderecos());
    }

    @Override
    public List<PessoaListResponse> listaPessoas() {
        log.info("[inicia] PessoaApplicationService - listaPessoas");
        List<Pessoa> pessoas = pessoaRepository.listaPessoas();
        List<Endereco> enderecos = enderecoRepository.listaEnderecosDaPessoa();
        log.info("[finaliza] PessoaApplicationService - listaPessoas");
        return PessoaListResponse.converte(pessoas,enderecos);
    }
}
