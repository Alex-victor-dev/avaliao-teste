package br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.application.repository;

import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoJpaRepository extends JpaRepository<Endereco, Long> {
}
