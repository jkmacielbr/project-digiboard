package br.com.digiboard.desafioweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "usuarios")
@Getter
@Setter
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String salt;
}
