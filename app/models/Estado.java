package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by emerson on 04/08/2014.
 */

@Entity(name = "est_estado")
@Table(name = "est_estado")
public class Estado implements Serializable {

    //public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Basic(optional = false)
    @Column(name = "est_id_estado")
    public Long id;

    @Column(name = "est_ds_descricao")
    public String descricao;

    @Column(name = "est_ds_sigla")
    public String sigla;
}
