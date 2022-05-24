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
public class Cidade {

    private int identificador;
    private String descricao;
    private Estado estado;

    @Override
    public String toString() {
        return descricao;
    }

}
