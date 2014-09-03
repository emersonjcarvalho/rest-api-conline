package utils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import models.EstudanteModelo;
import models.ValidationErrorDTO;
import play.cache.Cache;

import javax.validation.ConstraintViolation;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

/**
 * Created by w6c on 28/07/2014.
 */
public class ToolsUtil {

    //Objecto possibilita ler infos do arquivo application.conf
    final static Config config = ConfigFactory.load();

    final static String s3AccessKey = config.getString("s3.accesskey");
    final static String s3AecretKey = config.getString("s3.secretkey");

    //public final static Config configValidations = ConfigFactory.load("validations");

    //Cliente autenticado do Serviço Amazon AWS
    public static AWSCredentials awsCredentials = new BasicAWSCredentials(s3AccessKey, s3AecretKey);

    //#############################   EhCache built-in Play    ############################################

    /**
     *
     * @param contentType
     * @return Extensao do arquivo
     */
    public static String capturaExtensaoDoMimeType(String contentType) {
        //ex contentType = image/jpeg
        String delimiter = "/";
        String extensao = contentType.split(delimiter)[1].toString();

        return extensao.trim().toLowerCase();
    }

    /**
     *
     * @param nomeArquivo
     * @return Extensao do arquivo
     */
    public static String capturaExtensaoNomeArquivo(String nomeArquivo) {
        String delimiter = "\\.";

        String extensao;
        String[] arrayString;
        arrayString = nomeArquivo.split(delimiter);
        int tamanhoArray = arrayString.length; //nomeImagem.split(".").length;
        extensao = arrayString[tamanhoArray - 1].toString(); //nomeImagem.split(".")[tamanhoSplit].trim().toString();

        return extensao.toLowerCase();
    }

    /**
     *
     * @param filePath - Path completo até o arquivo
     * @return Mime Type do arquivo
     */
    public static String detectMimeTypeOfFile(String filePath){

        String fileMimeType =  null;
        try {
            Path pathAux = FileSystems.getDefault().getPath(filePath);

            fileMimeType = Files.probeContentType(pathAux);

            if (fileMimeType == null) {
                System.err.format("'%s' has an" + " unknown filetype.%n", pathAux);
            }

        } catch (IOException x) {
            System.err.println(x);
        }

        return fileMimeType;
    }

    public static ValidationErrorDTO ConstraintViolation2ValidationErrorDTO(Set<ConstraintViolation<EstudanteModelo>> constraintViolations){

        ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();

        for (ConstraintViolation<EstudanteModelo> constraintViolation : constraintViolations){

            validationErrorDTO.addFieldError(constraintViolation.getPropertyPath().toString() ,constraintViolation.getMessage());
        }

        return validationErrorDTO;
    }


    public static File getCacheWriteDisk(String nomeFileCache){
        System.out.println("(((((((((   ToolsUtil - getCacheWriteDisk - START: ");

        //PEGA FIle do ehCache
        File fileInCache = (File) Cache.get(nomeFileCache);

        if(fileInCache == null){
            System.out.println("fileInCache == null");
            return null;
        }

        //Cria NOVO nome no mesmo diretorio do arquivo do Cache(MultiParti recebido pelo Play no controller)
        String newPath = fileInCache.getParent() + "\\" + nomeFileCache;
        File newFileToInDiks = new File(newPath);

        if(newFileToInDiks.exists()){

            if(newFileToInDiks.canRead()){
                return newFileToInDiks;
            }else{
                newFileToInDiks.delete();
            }
        }

        System.out.println("((((((((( >> nomeFileCache:  " + nomeFileCache);
        System.out.println("((((((((( >> fileInCache.getName:  " + fileInCache.getName());
        System.out.println("((((((((( >> fileInCache.getAbsolutePath:  " + fileInCache.getAbsolutePath());


        System.out.println("newFileToInDiks.getName: " + newFileToInDiks.getName());
        System.out.println("newFileToInDiks.getAbsolutePath: " + newFileToInDiks.getAbsolutePath());

        //CRIA arquivo com NOVO Nome.. O antigo é automativamente excluido pelo java.io.File
        if(fileInCache.renameTo(newFileToInDiks)){

            System.out.println("$@$@$@$@$@$@$@   fileInCache.renameTo(newFileToInDiks)   $@$@$@$@$@$@$@");

            /*
            if(fileInCache == null){
                System.out.println("fileInCache == null");

            }else if(fileInCache.exists()){
                System.out.println("fileInCache.exists()");
                System.out.println("newFileToInDiks.getName: " + newFileToInDiks.getName());
                System.out.println("- fileInCache.getAbsoluteFile" + fileInCache.getAbsoluteFile());

            }else if(fileInCache.canRead()){
                System.out.println("fileInCache.canRead()");
                System.out.println("- fileInCache.getAbsoluteFile" + fileInCache.getAbsoluteFile());
            }
            */

            System.out.println("$@$@$@$@$@$@$@   ((((((((())))))))))))   $@$@$@$@$@$@$@");

            /*
            if(newFileToInDiks == null){
                System.out.println("newFileToInDiks == null");

            }else if(newFileToInDiks.exists()){
                System.out.println("newFileToInDiks.exists()");
                System.out.println("- newFileToInDiks.getAbsoluteFile" + fileInCache.getAbsoluteFile());

            }else if(newFileToInDiks.canRead()){
                System.out.println("newFileToInDiks.canRead()");
                System.out.println("- newFileToInDiks.getAbsoluteFile" + fileInCache.getAbsoluteFile());
            }
            */

            return newFileToInDiks;

            //#CLEAN-RESOURCE: Limpa arquivo do ehCache
            //Cache.remove(nomeFileFotoCache);
        }else{
            System.out.println("ToolsUtil - getCacheWriteDisk: FALHOU");

            return null;
        }
    }


}
