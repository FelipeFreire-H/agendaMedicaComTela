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
public class Cargo {

    private int identificador;
    private String descricao;
    private boolean ativo;

    @Override
    public String toString() {
        return this.descricao;
    }

}
