package controllers;

//import actors.ActorHelper;
//import actors.mail.EmailConfirmacaoMessage;
//import actors.mail.EmailOperacionalMessage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import models.*;
import models.repository.*;

import play.mvc.Controller;
import play.mvc.Result;
import play.libs.Json;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.List;

//import services.EmailService;

/**
 * Created by w6c on 04/08/2014.
 */


@Named
@Singleton
public class UserController extends Controller{


    //MUDAR P/ INJECAO DE DEPENDENCIA
    //final EmailService emailService = new EmailService(ActorHelper.getActorSystem());

    private final UsuarioRepository usuarioRepository;
    //private final GrupoRepository grupoRepository;
    private final CampusRepository campusRepository;
    private final EstadoRepository estadoRepository;
    private final SolicitacaoRepository solicitacaoRepository;
    private final EstudanteRepository estudanteRepository;

    @Inject
    public UserController(UsuarioRepository usuarioRepository,
                          EstadoRepository estadoRepository, CampusRepository campusRepository,
                          SolicitacaoRepository solicitacaoRepository, EstudanteRepository estudanteRepository) {
        this.usuarioRepository = usuarioRepository;
        //this.grupoRepository = grupoRepository;
        this.campusRepository = campusRepository;
        this.estadoRepository = estadoRepository;
        this.solicitacaoRepository = solicitacaoRepository;
        this.estudanteRepository = estudanteRepository;
    }

    public Result hello(){

        //Grupo operadores = new Grupo("Operadores");

        //grupoRepository.save(operadores);

        final Usuario usuario = new Usuario();
        //usuario.id = 2L;
        //usuario.nome = "Beatriz Carvalho";
        usuario.username = "bia.carvalho";
        usuario.password = "1234";
        usuario.enable = false;
        usuario.email = "bia@carvalho.com";

        //usuario.grupo = operadores;

        usuarioRepository.save(usuario);

        System.out.println("");
        System.out.println("usuario.username: " + usuario.username + " | usuario.password: " + usuario.password);
        //System.out.println("usuario.grupo.descricao: " + usuario.grupo.descricao);

        return ok(Json.toJson(usuario));
    }

    public Result campus(){
        List<Campus> campusList = (List<Campus>) campusRepository.findAll();

        return ok(Json.toJson(campusList));
    }

    public Result estados(){
        List<Estado> estadoList = (List<Estado>) estadoRepository.findAll();

        return ok(Json.toJson(estadoList));
    }

    public Result solicitacoes(){
        List<SolicitacaoModelo> solicitacaoList = (List<SolicitacaoModelo>) solicitacaoRepository.findAll();

        SimpleDateFormat sdf = new SimpleDateFormat();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.setDateFormat(sdf);
        Json.setObjectMapper(mapper);
        return ok(Json.toJson(solicitacaoList));
    }

    public Result estudantes(){
        List<EstudanteModelo> estudanteModeloList = (List<EstudanteModelo>) estudanteRepository.findAll();

        return ok(Json.toJson(estudanteModeloList));
    }

    public Result getAllUsers(){

        List<Usuario> usuarioList = (List<Usuario>) usuarioRepository.findAll();

        return ok(Json.toJson(usuarioList));
    }

    public Result getUserById(Long id){
        return ok(Json.toJson("getUserById - ID: " + id));
    }

    public Result saveUser(){
        JsonNode jsonBodyRequest = request().body().asJson();
        final Usuario usuarioRequest = Json.fromJson(jsonBodyRequest, Usuario.class);

        final Usuario usuarioSaved = usuarioRepository.save(usuarioRequest);

        return ok(Json.toJson(usuarioSaved));
    }

    public Result updateUser(Long id){

        JsonNode jsonFromRequest = request().body().asJson();
        Usuario usuario = Json.fromJson(jsonFromRequest, Usuario.class);
        usuario.id = id;

        return ok(Json.toJson(usuario));
    }


    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$      Testes Email        $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    /*
    public Result simpleEmail(String to){

        String subject = "TestMail - ACTOR Commons-Mail";
        String MsgTextBody = "TExto Alternativo";
        String MsgHtmlBody = "This is a test mail ... :-) TO: " + to;

        File attachementTest = new File("C:\\z800.jpg");

        EmailConfirmacaoMessage emailConfirmacaoPOJO = new EmailConfirmacaoMessage(subject,MsgTextBody,MsgHtmlBody, to);

        EmailOperacionalMessage emailOperacionalPojo =
                new EmailOperacionalMessage("Assunto Operacional", "Alternative text Operacional", "HTML operacional", "", attachementTest, attachementTest);

        emailService.sendEmailConfirmacao(emailConfirmacaoPOJO);

        if(attachementTest.exists()){
            emailService.sendEmailOperacional(emailOperacionalPojo);
            return ok(play.libs.Json.toJson("Message send to Actor for Email: " +to + " at  " + new Date()));
        }else{
            return notFound("File not found");
        }
    }
    */

    // ########################################################################################################
    // ############################################## ENABLE CORS #############################################

    private static Result allowCORS() {
        response().setHeader("Access-Control-Allow-Origin", "*");
        response().setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response().setHeader("Access-Control-Max-Age", "300");
        response().setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return ok();
    }

    public static Result option() {
        return allowCORS();
    }

    public static Result optionID(Long id) {
        return allowCORS();
    }


/*

  ### TESTS SPRING-DATA-JPA
GET     /hello                      @controllers.UserController.hello

GET     /users                      @controllers.UserController.getAllUsers
GET     /users/:id                  @controllers.UserController.getUserById(id: Long)
POST    /users                      @controllers.UserController.saveUser
PUT     /users/:id                  @controllers.UserController.updateUser(id: Long)

GET     /solicitacoes               @controllers.UserController.solicitacoes
GET     /estudantes                 @controllers.UserController.estudantes

OPTIONS     /users      	        controllers.UserController.option()



*/

}
