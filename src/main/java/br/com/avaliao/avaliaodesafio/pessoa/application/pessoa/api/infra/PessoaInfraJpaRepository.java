package br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.infra;

import br.com.avaliao.avaliaodesafio.pessoa.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaInfraJpaRepository extends JpaRepository<Pessoa, Long> {
}
