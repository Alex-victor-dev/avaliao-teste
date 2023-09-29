package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.service;

import br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.application.repository.EnderecoRepository;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.api.PessoaDetalhadaResponse;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.repository.PessoaRepository;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaAlteracaoRequest;
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
        List<Endereco> enderecos = pessoaRequest.converterEnderecosDeRequest(pessoaRequest,pessoa);
        pessoa.relacionaEndereco(enderecos);
        pessoaRepository.salvaPessoa(pessoa);
        enderecoRepository.salvaEnderecosAsociadoApessoa(pessoa.getConverteEnderecos());
        log.info("[finaliza] PessoaApplicationService - cadastraPessoa");
        return new PessoaResponse(pessoa, pessoa.getConverteEnderecos());
    }
    
    @Override
    public List<PessoaListResponse> listaPessoas() {
        log.info("[inicia] PessoaApplicationService - listaPessoas");
        List<Pessoa> pessoas = pessoaRepository.listaPessoas();
        List<Endereco> enderecos = enderecoRepository.listaEnderecosDaPessoa();
        log.info("[finaliza] PessoaApplicationService - listaPessoas");
        return PessoaListResponse.converte(pessoas,enderecos);
    }

    @Override
    public void alteraPessoa(PessoaAlteracaoRequest pessoaAlteracaoRequest, Long id) {
        log.info("[inicia] PessoaApplicationService - alteraPessoa");
        Pessoa pessoa = pessoaRepository.buscaPessoaId(id);
        pessoa.alteraCadastro(pessoaAlteracaoRequest);
        pessoaRepository.salvaPessoa(pessoa);
        log.info("[finaliza] PessoaApplicationService - alteraPessoa");

    }

    @Override
    public PessoaDetalhadaResponse detalhaPessoaPorId(Long id) {
        log.info("[inicia] PessoaApplicationService - detalhaPessoaPorId");
        Pessoa pessoa = pessoaRepository.buscaPessoaId(id);
        List<Endereco> listaDeEndereco = enderecoRepository.listaEnderecosDaPessoa();
        return new PessoaDetalhadaResponse(pessoa,listaDeEndereco);
    }
}
