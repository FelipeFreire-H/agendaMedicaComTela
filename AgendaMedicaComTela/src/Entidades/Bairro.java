package Entidades;

import lombok.*;

/**
 *
 * @author Ioliveira
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bairro {

    private int identificador;
    private String descricao;
    private Cidade cidade;

}
