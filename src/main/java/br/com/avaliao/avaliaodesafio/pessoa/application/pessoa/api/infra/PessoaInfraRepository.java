package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.infra;

import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.application.repository.PessoaRepository;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
