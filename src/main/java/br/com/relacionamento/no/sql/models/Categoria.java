package br.com.relacionamento.no.sql.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "categorias")
public class Categoria {
    @Id
    private String id;
    private String nome;
}
