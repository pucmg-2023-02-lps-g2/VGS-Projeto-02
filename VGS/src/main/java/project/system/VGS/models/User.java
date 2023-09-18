package project.system.VGS.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Data
@Document(collection = "usuarios")
public class User {

    @Id
    private String cpf;
    private String nome;
    private String endereco;
    private String rg;
}
