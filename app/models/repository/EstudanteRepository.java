package models.repository;

import models.EstudanteModelo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by emerson on 04/08/2014.
 */

@Named
@Singleton
public interface EstudanteRepository extends JpaRepository<EstudanteModelo, Long>{
}
