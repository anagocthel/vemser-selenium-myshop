package dataFactory;

import dtos.CadastroDTO;
import dtos.EnderecoDTO;
import net.datafaker.Faker;

public class EnderecoDataFactory {

    private static Faker faker = new Faker();

    public EnderecoDTO enderecoValido(){
        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setCity(faker.address().cityName());
        enderecoDTO.setAddress(faker.address().streetAddress());
        enderecoDTO.setCompany(String.valueOf(faker.company()));
        enderecoDTO.setTitle("My home");
        enderecoDTO.setHomePhone(String.valueOf(faker.phoneNumber()));
        enderecoDTO.setZipCode(faker.address().zipCode());

        return enderecoDTO;
    }
}
