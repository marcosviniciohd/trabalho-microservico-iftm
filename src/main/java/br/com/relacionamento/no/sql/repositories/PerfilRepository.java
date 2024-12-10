package br.com.relacionamento.no.sql.repositories;

import br.com.relacionamento.no.sql.models.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends MongoRepository<Perfil, String> {

}
