package io.attornatusapirestjava.adapters.in.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public record PessoaDtoRequest(

        @NotBlank
        @Length(max = 100)
        String nome,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Formato de data inválido. Utilize o formato dd/MM/yyyy.")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        String dataNascimentoString
) { }

