package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by w6c on 04/08/2014.
 */

//@Entity
public class Grupo {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String descricao;

    //@OneToMany(mappedBy = "grupo", targetEntity = Usuario.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //public List<Usuario> usuarioList;


    public Grupo(String descricao) {
        this.descricao = descricao;
    }

    public Grupo() {
    }
}
