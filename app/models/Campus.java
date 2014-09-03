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

@Entity
@Table(name = "cam_campus")
public class Campus { //implements Serializable {

    //public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Basic(optional = false)
    @Column(name = "CAM_ID_CAMPUS")
    public Long id;
    //
    @Column(name = "CAM_ID_INSTITUICAO")
    public Long idInstituicao;

    @Column(name = "CAM_DS_CAMPUS")
    public String descricao;
}
