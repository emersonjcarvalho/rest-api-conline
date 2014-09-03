package models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import models.Usuario;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by w6c on 04/08/2014.
 */

@Named
@Singleton
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
