package br.com.digiboard.desafioweb.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "firstname")
    private String firstName;
    @NotBlank(message = "Sobrenome é obrigatório")
    @Column(name = "lastname")
    private String lastName;





    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "datebirth")
    private LocalDate dateBirth;


    //RELACIONAMENTO 1 PARA UM COM ADDRESS
    //OPERACOES EXECUTADAS NO Person SAO REFLETIDAS NA TABELA DO ADDRESS
    //
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;



}
