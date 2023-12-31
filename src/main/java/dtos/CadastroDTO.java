package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroDTO {
    private String emailCreate;
    private String firstName;
    private String lastName;
    private String password;
}
