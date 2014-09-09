package actors.mail;

import javax.activation.DataSource;
import java.io.File;

/**
 * Created by w6c on 27/07/2014.
 */

public class EmailOperacionalMessage {

    public final String subject;
    public final String messageBodyText;
    public final String templateHtmlMessage;
    //public final String to;

    //public final File attachmentFoto;
    //public final File attachmentDocumento;

    //public final byte[] bytesAttachmentFoto;
    //public final byte[] bytesAAttachmentDocumento;

    public final DataSource dataSourceAttachmentFoto;
    public final DataSource dataSourceAttachmentDocumento;

    public final String nomeFileFoto;
    public final String nomeFileDocumento;

    public EmailOperacionalMessage(String subject, String messageBodyText, String templateHtmlMessage,
                                   //File attachmentFoto, File attachmentDocumento,
                                   DataSource dataSourceAttachmentFoto, DataSource dataSourceAttachmentDocumento,
                                   String nomeFileFoto, String nomeFileDocumento) {

        this.subject = subject;
        this.messageBodyText = messageBodyText;
        this.templateHtmlMessage = templateHtmlMessage;

        //this.attachmentFoto = attachmentFoto;
        //this.attachmentDocumento = attachmentDocumento;

        this.dataSourceAttachmentFoto = dataSourceAttachmentFoto;
        this.dataSourceAttachmentDocumento = dataSourceAttachmentDocumento;

        this.nomeFileFoto = nomeFileFoto;
        this.nomeFileDocumento = nomeFileDocumento;
    }
}