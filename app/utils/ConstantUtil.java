package utils;

import models.EstudanteModelo;

/**
 * Created by w6c on 27/07/2014.
 */
public class ConstantUtil {

    public static final String SES_HOST_SMTP = ToolsUtil.config.getString("ses.host.smtp");

    public static final Integer SES_PORT_SMTP = ToolsUtil.config.getInt("ses.port.smtp");
    public static final String SES_USERNAME_SMTP = ToolsUtil.config.getString("ses.username.smtp");
    public static final String SES_PASSWORD_SMTP = ToolsUtil.config.getString("ses.password.smtp");
    //
    public static final String SES_EMAIL_FROM = ToolsUtil.config.getString("ses.email.from");
    public static final String SES_EMAIL_TO_OPERACIONAL = ToolsUtil.config.getString("ses.email.to.operacional");
    //public static final String SES_ASSUNTO_OPERACIONAL = "";
    public static final String SES_ASSUNTO_CONFIRMACAO = "Solicitação de Carteirinha de Estudante DCE UNIFACS";
    //
    public static final String BUCKET_NAME = ToolsUtil.config.getString("s3.bucket.name");
    public static final String DIRETORIO_FOTOS = "deposito/appCarteirinha/unifacs/fotos/";
    public static final String DIRETORIO_DOCUMENTOS = "deposito/appCarteirinha/unifacs/documentos/";
    //
    public static final String PREFIX_FOTO = "foto_";
    public static final String PREFIX_DOCUMENTO = "documento_";
    public static final String KEY_MULTIPARTI_FILE_UPLOAD_FOTO = "fotoFile";
    public static final String KEY_MULTIPARTI_FILE_UPLOAD_DOCUMENTO = "documentoFile";

    public static final String KEY_URL_SOLICITACAO_SUCESSO = "urlSolicitacaoSucesso";


    //#####################################    ########################
    public static final double PRECO_CARTEIRINHA = 25.0;
    public static final String PAGSEGURO_DESCRICAO_PRODUTO = "Carteira de Estudante DCE UNIFACS";
    public static final String PAGSEGURO_VALOR = "25.00";
    public static final String PAGSEGURO_PESO = "0";
    public static final String PAGSEGURO_CODIGO_PAIS = "BRA";
    //
    //VALORES FIXADOS TEMPORARIAMENTE P/ EVITAR ACESSOS AO BANCO DE DADOS
    public static final long ID_INSTITUICAO = 1; //UNIFACS
    public static final long ID_CARTEIRA = 1; //DCE UNIFACS
    public static final long ID_STATUS_SOL_INICIAL = 1; //Aguardando Analise
    public static final long ID_FORMA_PAGAMENTO = 1; //PAGSEGURO


    public static final String URL_MENSAGEM_PROBLEMA_GATEWAY_PAGAMENTO = "http://www.carteirinhaonline.com.br/pag-gateway-error.html";

    public static String getHtmlMsgConfirmacao(EstudanteModelo estudante) {
        String htmlMsg = "<HTML><BODY>"
                + "<H2> Solicitacao de Carteira de Estudante DCE UNIFACS </H2><BR><BR>"
                + "<p>Prezado(a) " + "<b>" + estudante.nome.toUpperCase() + "!</b>"
                + "Seus dados e documentos entrarão em processo de validação."
                + "<br>"
                + "Após a confirmação de pagamento do PagSeguro enviaremos para o processo de emissão."
                + "<br>"
                + "Fique atento pois toda a nossa cominunicação será através do email que você cadastrado."
                + "<br> <br>"
                + "Qualquer dúvida favor entrar em contato conosco"
                + "<br> <br>"
                + "Atenciosamente,"
                + "<br>"
                + "Equipe DCE UNIFACS"
                + "</BODY></HTML>";

        return htmlMsg;
    }


    public static String getHtmlMsgOperacional(EstudanteModelo estudante) {

        String htmlMsg = "<HTML><BODY>"
                + "<H2> SOLICITACAO DE CARTEIRINHA </H2><BR><BR>"
                + "<b>Nome: </b>" + estudante.nome + "<br>"
                + "<b>Email: </b>" + estudante.email + "<br>"
                + "<b>CPF: </b>" + estudante.cpf + "<br>"
                + "<b>RG: </b>" + estudante.cpf + "<br>"
                + "<b>Data Nascimento: </b>" + estudante.dataNascimento.toLocalDate().toString("dd/MM/yyyy") + "<br>"
                + "<b>Telefone: </b>" + "(" + estudante.codigo_area_telefone + ")" + estudante.telefone + "<br>"
                + "<b>Celular: </b>" + "(" + estudante.codigo_area_celular + ")" +  estudante.celular + "<br>"
                + "<br>"
                + "<b>Matricula: </b>" + estudante.matricula + "<br>"
                + "<b>Instituição: </b>" + estudante.idInstituicao + "<br>"
                + "<b>Curso: </b>" + estudante.curso + "<br>"
                //+ "<b>Tipo Periodo: </b>" + estudante.getTipoPeriodo() + "<br>"
                //+ "<b>Periodo: </b>" + estudante.getPeriodo() + "<br>"
                + "<br>"
                + "<b>Estado: </b>" + estudante.estado.descricao + "<br>"
                + "<b>Ciadde: </b>" + estudante.cidade + "<br>"
                + "<b>Endereço: </b>" + estudante.logradouro + "<br>"
                + "<b>Complemento: </b>" + estudante.complementoEndereco + "<br>"
                + "<b>Numero: </b>" + estudante.numeroEndereco + "<br>"
                + "<b>Bairro: </b>" + estudante.bairro + "<br>"
                + "<b>CEP: </b>" + estudante.cep + "<br>"
                //+ "<b>OK CONTRATO: </b>" + estudante.getOkContrato().toString() + "<br>"
                //+ "<b>FORMA PAGAMENTO: </b>" + estudante.getFormaPagamento() + "<br>"
                + "<b>LOCAL RETIRADA: </b>" + estudante.localEntrega.toString() + "<br>"
                + "<br>"
                //+ "<b>FOTO 3X4: </b>" + SERVER + estudante.getPath_fileFoto() + "<br>"
                //+ "<b>DOCUMENTO: </b>" + SERVER + estudante.getPath_fileDocumento() + "<br>"
                //+ "<b>COMP MATRICULA: </b>" + SERVER +  estudante.getPath_fileCompMatricula() + "<br>"
                + "</BODY></HTML>";

        return htmlMsg;
    }

}
