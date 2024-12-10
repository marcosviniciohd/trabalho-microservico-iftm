package br.com.relacionamento.no.sql.repositories;

import br.com.relacionamento.no.sql.models.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
