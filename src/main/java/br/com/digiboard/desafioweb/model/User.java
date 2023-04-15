package br.com.digiboard.desafioweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "users")
@Data
@Entity


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(unique = true)
    private String login;
    @Column
    private String password;
    @Column
    private String salt;
}
