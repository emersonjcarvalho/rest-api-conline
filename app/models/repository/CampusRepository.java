package models.repository;

import org.springframework.data.repository.CrudRepository;
import models.Campus;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by emerson on 04/08/2014.
 */

@Named
@Singleton
public interface CampusRepository extends CrudRepository<Campus, Long>{

}
