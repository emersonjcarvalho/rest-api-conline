package models;

import java.io.Serializable;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Created by emerson on 04/08/2014.
 */


@Entity(name = "sol_solicitacao")
@Table(name = "sol_solicitacao")
public class SolicitacaoModelo {//implements Serializable {

    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SOL_ID_SOLICITACAO")
    public Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "SOL_ID_ESTUDANTE", nullable = false)

    @ManyToOne
    @JoinColumn(name = "SOL_ID_ESTUDANTE")
    public EstudanteModelo estudante;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "SOL_ID_STATUS", nullable = false)
    //public StatusSolicitacaoModelo statusSolicitacao;
    @Column(name = "SOL_ID_STATUS")
    public Long idStatusSolicitacao;

    @Column(name = "SOL_DT_SOLICITACAO")
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    //public Date dataSolicitacao;
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime dataSolicitacao;


    @Column(name = "SOL_VL_CARTEIRA")
    public Double valorCarteira;

    @Column(name = "SOL_VL_PAGO")
    public Long valorPago;

    @Column(name = "SOL_DT_PAGAMENTO")
    //@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    //public Date dataPagamento;
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime dataPagamento;


    @Column(name = "SOL_FL_PAGO")
    public Boolean flagPago;

    @Column(name = "SOL_ID_FORMA_PAGAMENTO")
    public Long idFormaPagamento;

    @Column(name = "SOL_CD_LOCAL_ENTREGA")
    public Character codigoLocalEntrega;
}
