package project.system.VGS.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {

    @Getter
    @Id
    private String id;
    private String password;
    private String nome;
    private String rg;
    private String endereco;
    private boolean agente;
}
