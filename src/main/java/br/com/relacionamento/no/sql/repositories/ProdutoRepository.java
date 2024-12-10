package br.com.relacionamento.no.sql.repositories;

import br.com.relacionamento.no.sql.models.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
    Produto findByNome(String nome);
    List<Produto> queryByNomeLike(String nome);
    List<Produto> findByCategoriaId(String categoryId);
    Optional<Produto> findByProductIdentifier(String productIdentifier);
}
