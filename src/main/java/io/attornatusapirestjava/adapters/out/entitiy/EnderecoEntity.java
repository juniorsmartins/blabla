package io.attornatusapirestjava.adapters.out.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "enderecos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id", "logradouro", "cep", "numero", "cidade", "statusPrincipal", "pessoa"})
public final class EnderecoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "cep", length = 10, nullable = false)
    private String cep;

    @Column(name = "numero", length = 10, nullable = false)
    private String numero;

    @Column(name = "cidade", length = 100, nullable = false)
    private String cidade;

    @Column(name = "status_principal", nullable = false)
    private Boolean statusPrincipal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private PessoaEntity pessoa;
}

