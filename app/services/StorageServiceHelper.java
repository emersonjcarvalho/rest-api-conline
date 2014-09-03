package services;

import actors.s3aws.S3AWSSupervisor;
import actors.s3aws.S3FileObject;
import akka.actor.ActorRef;
import akka.actor.Props;
import play.cache.Cache;
import play.libs.Akka;
import utils.ConstantUtil;
import utils.ToolsUtil;

import java.io.File;
import java.util.Date;

/**
 * Created by w6c on 30/07/2014.
 */
public class StorageServiceHelper {

    ActorRef actorRefSupervisor = Akka.system().actorOf(Props.create(S3AWSSupervisor.class));


    public void salvarFotoStorage(String nomeFileFotoCache){

        //File fileToS3 = ToolsUtil.getCacheWriteDisk(nomeFileFotoCache);
        File fileToS3 = (File) Cache.get(nomeFileFotoCache);

        //CRIA arquivo com NOVO Nome.. O antigo é automativamente excluido pelo java.io.File
        if(fileToS3.canRead()){

            S3FileObject s3FileObject = new S3FileObject(ConstantUtil.BUCKET_NAME, ConstantUtil.DIRETORIO_FOTOS, nomeFileFotoCache, fileToS3);

            //Envia mensagem p/ Supervidor do Actor
            actorRefSupervisor.tell(s3FileObject, ActorRef.noSender());

            //#CLEAN-RESOURCE: Limpa arquivo do ehCache
            //Cache.remove(nomeFileFotoCache);

        }else{
            System.out.println("***************************************************************************************");
            System.out.println("StorageServiceHelper - salvarFotoStorage - fileToS3.renameTo: FALHOU");
            System.out.println("nomeFileFotoCache: " + nomeFileFotoCache + " - " + new Date());
            System.out.println("***************************************************************************************");
        }
    }

    public void salvarDocumentoStorage(String nomeFileDocumentoCache){

        //File fileToS3 = ToolsUtil.getCacheWriteDisk(nomeFileDocumentoCache);
        File fileToS3 = (File) Cache.get(nomeFileDocumentoCache);

        //CRIA arquivo com NOVO Nome.. O antigo é automativamente excluido pelo java.io.File
        if(fileToS3.canRead()){

            S3FileObject s3FileObject = new S3FileObject(ConstantUtil.BUCKET_NAME, ConstantUtil.DIRETORIO_FOTOS, nomeFileDocumentoCache, fileToS3);

            //Envia mensagem p/ Supervidor do Actor
            actorRefSupervisor.tell(s3FileObject, ActorRef.noSender());

            //#CLEAN-RESOURCE: Limpa arquivo do ehCache
            //Cache.remove(nomeFileDocumentoCache);

        }else{
            System.out.println("***************************************************************************************");
            System.out.println("StorageServiceHelper - salvarDocumentoStorage - fileToS3.renameTo: FALHOU");
            System.out.println("nomeFileDocumentoCache: " + nomeFileDocumentoCache + " - " + new Date());
            System.out.println("***************************************************************************************");
        }
    }
}
