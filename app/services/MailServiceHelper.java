package services;

import actors.mail.SupervisorMail;
import akka.actor.ActorRef;
import akka.actor.Props;
import play.libs.Akka;

import actors.mail.EmailNotificacaoMessage;
import actors.mail.EmailOperacionalMessage;
import utils.ConstantUtil;
import utils.ToolsUtil;

import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;
import java.util.Date;

/**
 * Created by w6c on 26/07/2014.
 */


public class MailServiceHelper {

    static ActorRef supervisorRef =  Akka.system().actorOf(Props.create(SupervisorMail.class), "supervisor-Ref");

    public MailServiceHelper() {
        System.out.println("MailServiceHelper ID: " + System.identityHashCode(this) + " - " + new Date());
    }

    public static void sendMailNotificacao(EmailNotificacaoMessage emailNotificacaoMessage){

        supervisorRef.tell(emailNotificacaoMessage, supervisorRef);
    }

    public static void sendMailOperacional(String subject, String messageBodyText, String templateHtmlMessage,
                                           byte[] bytesAttachmentFoto, byte[] bytesAAttachmentDocumento,
                                           String typeAttachmentFoto, String typeAttachmentDocumento,
                                           String nomeFileFoto, String nomeFileDocumento){

        DataSource dataSourceAttachmentFoto = new ByteArrayDataSource(bytesAttachmentFoto,typeAttachmentFoto);

        DataSource dataSourceAttachmentDocumento = new ByteArrayDataSource(bytesAAttachmentDocumento,typeAttachmentDocumento);

        EmailOperacionalMessage emailOperacionalMessage =
                new EmailOperacionalMessage(subject, messageBodyText, templateHtmlMessage,
                        dataSourceAttachmentFoto, dataSourceAttachmentDocumento,
                        nomeFileFoto, nomeFileDocumento);

        supervisorRef.tell(emailOperacionalMessage, supervisorRef);
    }

    public void terminate(){
        //TODO
    }
}
