package models;

import java.io.Serializable;
//import java.util.Date;
//import java.sql.Date;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import utils.ConstantUtil;
import utils.CustomJsonDateDeserializer;
import org.joda.time.DateTime;

import org.joda.time.contrib.hibernate.PersistentDateTime;
import utils.ToolsUtil;
import utils.ValidationsMessages;

/**
 * Created by emerson on 04/08/2014.
 */

@Entity(name = "est_estudante")
@Table(name = "est_estudante")
public class EstudanteModelo {//implements Serializable {

    //public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EST_ID_ESTUDANTE")
    public Long id;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    //@Pattern(regexp = "^$|[0-9]", message = ValidationsMessages.MSG_ONLY_NUMBER)
    @CPF(message = ValidationsMessages.MSG_CPF_INVALIDO)
    @Column(name = "EST_DS_CPF", length = 11) //unique = true,
    public String cpf;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    //@Pattern(regexp = "(^$|[0-9])", message = ValidationsMessages.MSG_ONLY_NUMBER)
    @Size(max = 15, message = "Deve conter no máximo {max} digitos")
    @Digits(fraction = 0, integer = 15, message = ValidationsMessages.MSG_ONLY_NUMBER)
    @Column(name = "EST_DS_RG", length = 15)
    public String rg;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 100, message = "Deve conter no máximo {max} digitos")
    @Column(name = "EST_DS_NOME", length = 100)
    public String nome;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 25, message = "Deve conter no máximo {max} digitos")
    @Column(name = "EST_DS_NOME_EXIBICAO", length = 25)
    public String nomeExibicao;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    //@Pattern(regexp = "^[M|F]{1}$", message ="Deve ser [M] ou [F]")
    @Size(min = 1, max = 1, message = "Deve conter {min} digitos")
    //@Min(value = 1, message = "Deve conter no 1 digito") //@Max(value = 1, message = "Deve conter no 1 digito")
    @Column(name = "EST_CD_SEXO", length = 1)
    public String sexo; //public Character sexo;

    @NotNull(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Column(name = "EST_DT_NASCIMENTO")
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    //@JsonFormat(pattern = "yyyy-MM-dd")
    public DateTime dataNascimento; //public DateTime dataNascimento;

    //@Column(name = "EST_DS_URL_FOTO")
    //public String urlFoto;
    //@Column(name = "EST_DS_URL_COPIA_DOCUMENTO")
    //public String urlCopiaDocumento;
    //@Column(name = "EST_DS_URL_COMPROVANTE_ENDERECO")
    //public String urlComprovanteEndereco;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Email(message = ValidationsMessages.MSG_EMAIL_INVALIDO)
    @Size(max = 100, message = "Deve conter no maximo {max} digitos")
    @Column(name = "EST_DS_EMAIL", length = 100)
    public String email;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(min = 2, max = 2, message = "Deve conter {min} digitos")
    @Digits(fraction = 0, integer = 2, message = ValidationsMessages.MSG_ONLY_NUMBER)
    @Column(name = "EST_NU_CODIGO_AREA_TELEFONE", length = 2)
    public String codigo_area_telefone;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(min = 8, max = 10, message = "Deve conter entre {min} a {max} digitos")
    @Digits(fraction = 0, integer = 10, message = ValidationsMessages.MSG_ONLY_NUMBER)
    @Column(name = "EST_NU_TELEFONE", length = 10)
    public String telefone;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(min = 2, max = 2, message = "Deve conter {min} digitos")
    @Digits(fraction = 0, integer = 2, message = ValidationsMessages.MSG_ONLY_NUMBER)
    @Column(name = "EST_NU_CODIGO_AREA_CELULAR", length = 2)
    public String codigo_area_celular;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(min = 8, max = 10, message = "Deve conter entre {min} a {max} digitos")
    @Digits(fraction = 0, integer = 10, message = ValidationsMessages.MSG_ONLY_NUMBER)
    @Column(name = "EST_NU_CELULAR", length = 10)
    public String celular;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(min = 8, max = 8, message = "Deve conter {min} digitos")
    @Digits(fraction = 0, integer = 8, message = ValidationsMessages.MSG_ONLY_NUMBER)
    @Column(name = "EST_NU_CEP", length = 8)
    public String cep;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 150, message = "Deve conter no maximo {max} digitos")
    @Column(name = "EST_DS_LOGRADOURO", length = 150)
    public String logradouro;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 10, message = "Deve conter no maximo {max} digitos")
    @Column(name = "EST_NU_ENDERECO", length = 10)
    public String numeroEndereco;

    //@NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 50, message = "Deve conter no maximo {max} digitos")
    @Column(name = "EST_DS_COMPLEMENTO_ENDERECO", length = 50)
    public String complementoEndereco;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 30, message = "Deve conter no maximo {max} digitos")
    @Column(name = "EST_DS_BAIRRO", length = 30)
    public String bairro;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 70, message = "Deve conter no maximo {max} digitos")
    @Column(name = "EST_DS_CIDADE", length = 70)
    public String cidade;

    @NotNull(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @ManyToOne
    @JoinColumn(name = "EST_ID_ESTADO")
    public Estado estado;

    @NotNull(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Column(name = "EST_ID_INSTITUICAO")
    public Long idInstituicao;

    @NotNull(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @ManyToOne
    @JoinColumn(name = "EST_ID_CAMPUS")
    public Campus campus;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 50, message = "Deve conter no maximo {max} digitos")
    @Column(name = "EST_DS_CURSO", length = 50)
    public String curso;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 25, message = "Deve conter no máximo {max} digitos")
    @Column(name = "EST_DS_CURSO_EXIBICAO", length = 25)
    public String cursoExibicao;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 10, message = "Deve conter no máximo {max} digitos")
    @Column(name = "EST_DS_MATRICULA", length = 10)
    public String matricula;

    //@NotNull(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(min = 1, max = 1, message = "Deve conter {min} digitos")
    @Column(name = "EST_CD_LOCAL_ENTREGA", length = 1)
    public String localEntrega;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudante")
    //public Set<SolicitacaoModelo> listaSolicitacao = new HashSet<SolicitacaoModelo>(0);

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 50, message = "Deve conter no maximo {max} digitos")
    @Column(name = "EST_DS_NOME_ARQ_FOTO", length = 50)
    public String nomeArquivoFoto;

    @NotEmpty(message =  ValidationsMessages.MSG_NOT_EMPTY)
    @Size(max = 50, message = "Deve conter no maximo {max} digitos")
    @Column(name = "EST_DS_NOME_ARQ_DOCUMENTO",length = 50)
    public String nomeArquivoDocumento;

}
