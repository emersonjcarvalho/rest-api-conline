package models;

import javax.persistence.*;

/**
 * Created by w6c on 04/08/2014.
 */

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    //public String nome;
    //public String login;
    //public String senha;

    public String username;
    public String password;
    public Boolean enable;
    public String email;

    //@JoinColumn(name = "usuario_id")

    //@ManyToOne
    //public Grupo grupo;

}