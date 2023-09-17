package br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.infra;

import br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.application.repository.EnderecoRepository;
import br.com.avaliao.avaliaodesafio.pessoa.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
@Log4j2
@Repository
@RequiredArgsConstructor
public class EnderecoInfraJpaRepository implements EnderecoRepository {

    private final EnderecoJpaRepository enderecoJpaRepository;
    @Override
    public List<Endereco> listaEnderecosDaPessoa() {
        List<Endereco> enderecos = enderecoJpaRepository.findAll();
        return enderecos;
    }

    @Override
    public void salvaEnderecosAsociadoApessoa(List<Endereco> enderecos) {
        enderecoJpaRepository.saveAll(enderecos);
    }
}
