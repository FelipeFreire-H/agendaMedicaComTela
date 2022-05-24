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
public class Telefone {

    private int identificador;
    private int ddd;
    private String numero;
    private TipoTelefone tipoTelefone;

    @Override
    public String toString() {
      return "(" + ddd + ")" + numero;
    }

    
    
}
