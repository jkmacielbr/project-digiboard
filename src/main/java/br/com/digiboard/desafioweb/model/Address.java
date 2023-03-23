package br.com.digiboard.desafioweb.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Rua obrigatório")
    private String street;
    @NotNull(message = "Número obrigatório")
    @Column(name = "number")
    private Long numberHouse;
    @NotBlank(message = "Bairro obrigatório")
    private String neighborhood;
    @NotBlank(message = "Cidade obrigatório")
    private String city;
    @NotBlank(message = "Estado obrigatório")
    private String state;
    @NotBlank(message = "Country obrigatório")
    private String  country;

}
