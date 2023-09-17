package br.com.avaliao.avaliaodesafio.pessoa.domain;

import br.com.avaliao.avaliaodesafio.pessoa.application.endereco.api.request.EnderecoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Endereco(EnderecoRequest enderecoRequest) {
        this.logradouro = enderecoRequest.getLogradouro();
        this.cep = enderecoRequest.getCep();
        this.numero = enderecoRequest.getNumero();
        this.cidade = enderecoRequest.getCidade();
    }

    public Endereco(EnderecoRequest enderecoRequest, Pessoa pessoa) {
        this.logradouro = enderecoRequest.getLogradouro();
        this.cep = enderecoRequest.getCep();
        this.numero = enderecoRequest.getNumero();
        this.cidade = enderecoRequest.getCidade();
        this.pessoa = pessoa;
    }
}
