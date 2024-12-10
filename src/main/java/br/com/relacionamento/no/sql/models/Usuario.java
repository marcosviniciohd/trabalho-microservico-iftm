package br.com.relacionamento.no.sql.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "usuarios")
public class Usuario {
    private String id;
    private String nome;

    @DBRef
    private Perfil perfil;

    @DBRef
    private List<Postagem> postagens;
}
