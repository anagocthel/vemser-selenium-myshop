package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String addresLine2;
    private String city;
    private String homePhone;
    private String mobilePhone;
    private String additionalInformation;
    private String title;
    private String zipCode;

}
