package br.com.avaliao.avaliaodesafio.pessoa.domain;

import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaAlteracaoRequest;
import br.com.avaliao.avaliaodesafio.pessoa.application.pessoa.api.request.PessoaRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Endereco> converteEnderecos = new ArrayList<>();

    public Pessoa(PessoaRequest pessoaRequest) {
        this.nome = pessoaRequest.getNome();
        this.dataNascimento = pessoaRequest.getDataNascimento();
        this.converteEnderecos = pessoaRequest.getEndereco().stream()
                .map(Endereco::new)
                .collect( Collectors.toList());
    }

    public void alteraCadastro(PessoaAlteracaoRequest pessoaAlteracaoRequest) {
        this.nome = pessoaAlteracaoRequest.getNome();
    }

    public void relacionaEndereco(List<Endereco> enderecos) {
        this.converteEnderecos = enderecos;
    }

    }



