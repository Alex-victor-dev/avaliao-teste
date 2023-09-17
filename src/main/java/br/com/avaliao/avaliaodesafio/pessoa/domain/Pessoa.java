package br.com.avaliao.avaliaodesafio.pessoa.domain;

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
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(PessoaRequest pessoaRequest) {
        this.nome = pessoaRequest.getNome();
        this.dataNascimento = pessoaRequest.getDataNascimento();
        this.enderecos = pessoaRequest.getEndereco().stream()
                .map(Endereco::new)
                .collect(Collectors.toList());
    }
}


