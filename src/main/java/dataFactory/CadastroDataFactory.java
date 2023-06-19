package dataFactory;

import dtos.CadastroDTO;
import net.datafaker.Faker;

public class CadastroDataFactory {
    private static Faker faker = new Faker();

    public String emailValido(){
        return faker.internet().emailAddress();
    }
    public CadastroDTO cadastroValido() {
        CadastroDTO cadastroDTO = new CadastroDTO();
        cadastroDTO.setFirstName(faker.name().firstName());
        cadastroDTO.setLastName(faker.name().lastName());
        cadastroDTO.setPassword(faker.internet().password());
        cadastroDTO.setEmailCreate(faker.internet().emailAddress());
        return cadastroDTO;
    }
    public CadastroDTO cadastroSemPrimeiroNome() {
        CadastroDTO cadastroDTO = new CadastroDTO();
        cadastroDTO.setFirstName("");
        cadastroDTO.setLastName(faker.name().lastName());
        cadastroDTO.setPassword(faker.internet().password());
        cadastroDTO.setEmailCreate(faker.internet().emailAddress());
        return cadastroDTO;
    }
    public CadastroDTO cadastroSemSobrenome() {
        CadastroDTO cadastroDTO = new CadastroDTO();
        cadastroDTO.setFirstName(faker.name().firstName());
        cadastroDTO.setLastName("");
        cadastroDTO.setPassword(faker.internet().password());
        cadastroDTO.setEmailCreate(faker.internet().emailAddress());
        return cadastroDTO;
    }
    public CadastroDTO cadastroSemSenha() {
        CadastroDTO cadastroDTO = new CadastroDTO();
        cadastroDTO.setFirstName(faker.name().firstName());
        cadastroDTO.setLastName(faker.name().lastName());
        cadastroDTO.setPassword("");
        cadastroDTO.setEmailCreate(faker.internet().emailAddress());
        return cadastroDTO;
    }

    public CadastroDTO login() {
        CadastroDTO cadastroDTO = new CadastroDTO();
        cadastroDTO.setPassword(faker.internet().password());
        cadastroDTO.setEmailCreate(faker.internet().emailAddress());
        return cadastroDTO;
    }
    public CadastroDTO loginExistente() {
        CadastroDTO cadastroDTO = new CadastroDTO();
        cadastroDTO.setPassword("12345678");
        cadastroDTO.setEmailCreate("teste@teste.com");
        return cadastroDTO;
    }
}
