package br.com.relacionamento.no.sql.repositories;

import br.com.relacionamento.no.sql.models.Postagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {

}
