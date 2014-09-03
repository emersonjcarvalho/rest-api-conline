package models.repository;

import models.SolicitacaoModelo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by emerson on 04/08/2014.
 */
@Named
@Singleton
public interface SolicitacaoRepository extends JpaRepository<SolicitacaoModelo, Long> {

}
