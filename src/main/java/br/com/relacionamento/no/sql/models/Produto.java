package br.com.relacionamento.no.sql.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "produtos")
public class Produto {
    @Id
    private String id;
    private String productIdentifier;
    private String nome;
    private String descricao;
    private String preco;

    @DBRef
    private Categoria categoria;
}
