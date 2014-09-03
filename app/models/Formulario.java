package models;

import java.io.File;
import java.util.Date;

/**
 * Created by emerson on 19/08/2014.
 */
public class Formulario {

    //DADOS PESSOAIS
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String codigo_area_telefone;
    private String telefone;
    private String codigo_area_celular;
    private String celular;
    //DADOS ACADEMICOS
    private String matricula;
    private String instituicao;
    private String curso;
    private String tipoPeriodo;
    private String periodo;
    //ENDERECO
    private String endereco_estado;
    private String endereco_cidade;
    private String endereco_bairro;
    private String endereco_numero;
    private String endereco_logradouro;
    private String endereco_complemento;
    private String endereco_cep;
    private Boolean okContrato;
    private String formaPagamento;
    private String localRetirada;
    //ANEXOS
    private String path_fileFoto;
    private String path_fileDocumento;
    private String path_fileCompMatricula;
    private String path_fileCompDeposito;
    private File fileFoto;
    private File fileDocumento;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco_bairro() {
        return endereco_bairro;
    }

    public void setEndereco_bairro(String endereco_bairro) {
        this.endereco_bairro = endereco_bairro;
    }

    public String getEndereco_cep() {
        return endereco_cep;
    }

    public void setEndereco_cep(String endereco_cep) {
        this.endereco_cep = endereco_cep;
    }

    public String getEndereco_cidade() {
        return endereco_cidade;
    }

    public void setEndereco_cidade(String endereco_cidade) {
        this.endereco_cidade = endereco_cidade;
    }

    public String getEndereco_complemento() {
        return endereco_complemento;
    }

    public void setEndereco_complemento(String endereco_complemento) {
        this.endereco_complemento = endereco_complemento;
    }

    public String getEndereco_estado() {
        return endereco_estado;
    }

    public void setEndereco_estado(String endereco_estado) {
        this.endereco_estado = endereco_estado;
    }

    public String getEndereco_logradouro() {
        return endereco_logradouro;
    }

    public void setEndereco_logradouro(String endereco_logradouro) {
        this.endereco_logradouro = endereco_logradouro;
    }

    public String getEndereco_numero() {
        return endereco_numero;
    }

    public void setEndereco_numero(String endereco_numero) {
        this.endereco_numero = endereco_numero;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getLocalRetirada() {
        return localRetirada;
    }

    public void setLocalRetirada(String localRetirada) {
        this.localRetirada = localRetirada;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getOkContrato() {
        return okContrato;
    }

    public void setOkContrato(Boolean okContrato) {
        this.okContrato = okContrato;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(String tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public String getPath_fileCompMatricula() {
        return path_fileCompMatricula;
    }

    public void setPath_fileCompMatricula(String path_fileCompMatricula) {
        this.path_fileCompMatricula = path_fileCompMatricula;
    }

    public String getPath_fileDocumento() {
        return path_fileDocumento;
    }

    public void setPath_fileDocumento(String path_fileDocumento) {
        this.path_fileDocumento = path_fileDocumento;
    }

    public String getPath_fileFoto() {
        return path_fileFoto;
    }

    public void setPath_fileFoto(String path_fileFoto) {
        this.path_fileFoto = path_fileFoto;
    }

    public String getCodigo_area_celular() {
        return codigo_area_celular;
    }

    public void setCodigo_area_celular(String codigo_area_celular) {
        this.codigo_area_celular = codigo_area_celular;
    }

    public String getCodigo_area_telefone() {
        return codigo_area_telefone;
    }

    public void setCodigo_area_telefone(String codigo_area_telefone) {
        this.codigo_area_telefone = codigo_area_telefone;
    }

    public String getPath_fileCompDeposito() {
        return path_fileCompDeposito;
    }

    public void setPath_fileCompDeposito(String path_fileCompDeposito) {
        this.path_fileCompDeposito = path_fileCompDeposito;
    }

    public File getFileFoto() {
        return fileFoto;
    }

    public void setFileFoto(File fileFoto) {
        this.fileFoto = fileFoto;
    }

    public File getFileDocumento() {
        return fileDocumento;
    }

    public void setFileDocumento(File fileDocumento) {
        this.fileDocumento = fileDocumento;
    }

}




