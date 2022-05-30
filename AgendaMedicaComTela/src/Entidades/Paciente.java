
package Entidades;

import java.util.Date;
import lombok.*;
@Getter
@Setter
public class Paciente {
    
    private int id;
    private String cpf;
    private String nome;
    private String telefone;
    private Date dataNascimento;
    private String endereco;
    private char sexo;   
    
}
