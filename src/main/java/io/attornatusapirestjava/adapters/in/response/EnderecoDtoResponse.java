package io.attornatusapirestjava.adapters.in.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnderecoDtoResponse(

        Long id,

        String logradouro,

        String cep,

        String numero,

        String cidade,

        Boolean statusPrincipal
) { }

