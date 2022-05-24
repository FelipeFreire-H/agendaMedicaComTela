
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
public class Logradouro {
    
    private int identificador;
    private String descricao;
    private Bairro bairro;
    
}
