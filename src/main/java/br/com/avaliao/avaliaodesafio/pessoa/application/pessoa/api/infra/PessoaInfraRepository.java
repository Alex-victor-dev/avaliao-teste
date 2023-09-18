package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.infra;

import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.repository.PessoaRepository;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Log4j2
@Repository
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {
    private final PessoaInfraJpaRepository pessoaInfraJpaRepository;
    @Override
    public Pessoa salvaPessoa(Pessoa pessoa) {
        log.info("[inicia] PessoaInfraRepository - salvaPessoa");
        pessoaInfraJpaRepository.save(pessoa);
        log.info("[finaliza] PessoaInfraRepository - salvaPessoa");
        return pessoa;
    }

    @Override
    public List<Pessoa> listaPessoas() {
        log.info("[inicia] PessoaInfraRepository - listaPessoas");
        List<Pessoa> pessoas = pessoaInfraJpaRepository.findAll();
        log.info("[finaliza] PessoaInfraRepository - listaPessoas");
        return pessoas;
    }

    @Override
    public Pessoa buscaPessoaId(Long id) {
        log.info("[inicia] PessoaInfraRepository - buscaPessoaId");
        Pessoa pessoa = pessoaInfraJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa com ID "));
        log.info("[finaliza] PessoaInfraRepository - buscaPessoaId");
        return pessoa;
    }
}
