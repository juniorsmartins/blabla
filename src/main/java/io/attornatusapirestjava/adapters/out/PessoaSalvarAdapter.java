package io.attornatusapirestjava.adapters.out;

import io.attornatusapirestjava.adapters.out.mapper.PessoaEntityMapper;
import io.attornatusapirestjava.adapters.out.repository.PessoaRepository;
import io.attornatusapirestjava.application.core.domain.Pessoa;
import io.attornatusapirestjava.application.core.usecase.PessoaCriarUseCase;
import io.attornatusapirestjava.application.ports.out.PessoaSalvarOutputPort;
import io.attornatusapirestjava.configs.exception.http500.FalhaAoCriarException;
import io.attornatusapirestjava.configs.exception.http500.FalhaAoSalvarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Component
public class PessoaSalvarAdapter implements PessoaSalvarOutputPort {

    private final Logger logger = Logger.getLogger(PessoaSalvarAdapter.class.getName());

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaEntityMapper pessoaEntityMapper;

    @Override
    public Pessoa salvar(Pessoa pessoa) {

        logger.info("Salvar uma pessoa.");

        return Optional.of(pessoa)
                .map(this.pessoaEntityMapper::toPessoaEntity)
                .map(this.pessoaRepository::save)
                .map(this.pessoaEntityMapper::toPessoa)
                .orElseThrow(() -> new FalhaAoSalvarException("Falha ao salvar uma pessoa."));
    }
}
