package models.repository;

import models.Estado;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by emerson on 04/08/2014.
 */
@Named
@Singleton
public interface EstadoRepository extends CrudRepository<Estado,Long>{
}
